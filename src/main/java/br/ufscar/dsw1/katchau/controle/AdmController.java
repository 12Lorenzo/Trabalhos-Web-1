package br.ufscar.dsw1.katchau.controle;

import br.ufscar.dsw1.katchau.dao.*;
import br.ufscar.dsw1.katchau.entidade.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//Faz o controle de Adm

@WebServlet(urlPatterns = "/adm/*")
public class AdmController extends HttpServlet {

    private CarroDAO carroDAO;
    private UsuarioDAO usuarioDAO;
    private ClienteDAO clienteDAO;
    private PropostaDAO propostaDAO;
    private LojaDAO lojaDAO;

    @Override
    public void init()
    {
        carroDAO = new CarroDAO();
        usuarioDAO = new UsuarioDAO();
        clienteDAO = new ClienteDAO();
        propostaDAO = new PropostaDAO();
        lojaDAO = new LojaDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Usuario user = (Usuario) request.getSession().getAttribute("user");
        if (user == null || user.getPapel() != 1){
            request.setAttribute("erro", "você não é adm, logue novamente");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        }

        lista(request, response);
    }

    private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //carros
        List<Carro> listaCarros = carroDAO.getAll();
        request.setAttribute("listaCarros", listaCarros);

        //usuarios
        List<Usuario> listaUsuarios = usuarioDAO.getAll();
        request.setAttribute("listaUsuarios", listaUsuarios);

        //clientes
        List<Cliente> listaClientes = clienteDAO.read();
        request.setAttribute("listaClientes", listaClientes);

        //propostas
        List<Proposta> listaPropostas = propostaDAO.getAll(); //Não esta funcionando
        request.setAttribute("listaPropostas", listaPropostas);

        //lojas
        List<Loja> listaLojas = lojaDAO.read();
        request.setAttribute("listaLojas", listaLojas);


        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/adm/PainelAdm.jsp");
        dispatcher.forward(request, response);
    }

}
