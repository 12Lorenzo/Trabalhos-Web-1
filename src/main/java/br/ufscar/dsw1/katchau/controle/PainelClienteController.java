package br.ufscar.dsw1.katchau.controle;

import br.ufscar.dsw1.katchau.dao.CarroDAO;
import br.ufscar.dsw1.katchau.dao.PropostaDAO;
import br.ufscar.dsw1.katchau.entidade.Carro;
import br.ufscar.dsw1.katchau.entidade.Cliente;
import br.ufscar.dsw1.katchau.entidade.Loja;
import br.ufscar.dsw1.katchau.entidade.Proposta;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

//Faz o controle do painel de cliente

@WebServlet(name = "PainelClienteController", value = "/painelCliente")
public class PainelClienteController extends HttpServlet {

    CarroDAO carroDAO;
    PropostaDAO propostaDAO;

    @Override
    public void init() {
        carroDAO = new CarroDAO();
        propostaDAO = new PropostaDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        lista(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        lista(request,response);
    }

    private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Cliente cliente = (Cliente) request.getSession().getAttribute("cliente");
        if (cliente == null){
            request.setAttribute("erro", 4);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/adm/erros.jsp");
            dispatcher.forward(request, response);
            return;
        }
        List<Proposta> ListaPropostas = propostaDAO.read(cliente);
        request.setAttribute("ListaPropostas", ListaPropostas);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/adm/PainelCliente.jsp");
        dispatcher.forward(request, response);
    }
}
