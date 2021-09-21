package br.ufscar.dsw1.katchau.controle;

import br.ufscar.dsw1.katchau.dao.AuthDAO;
import br.ufscar.dsw1.katchau.dao.CarroDAO;
import br.ufscar.dsw1.katchau.dao.PropostaDAO;
import br.ufscar.dsw1.katchau.entidade.Carro;
import br.ufscar.dsw1.katchau.entidade.Loja;
import br.ufscar.dsw1.katchau.entidade.Proposta;
import br.ufscar.dsw1.katchau.entidade.Usuario;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PainelLojaController", value = "/painel")
public class PainelLojaController extends HttpServlet {
    CarroDAO carroDAO;
    PropostaDAO propostaDAO;

    @Override
    public void init() {
        carroDAO = new CarroDAO();
        propostaDAO = new PropostaDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lista(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lista(request, response);
    }

    private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Loja loja = (Loja) request.getSession().getAttribute("loja");
        if (loja == null){
            RequestDispatcher dispatcher = request.getRequestDispatcher("./login.jsp");
            dispatcher.forward(request, response);
        }
        List<Proposta> ListaPropostas = propostaDAO.getAll(loja.getCnpj());
        request.setAttribute("ListaPropostas", ListaPropostas);

        List<Carro> listaCarros = carroDAO.getAll(loja.getCnpj());
        request.setAttribute("ListaCarros", listaCarros);
        System.out.println("listacaro - >{"+listaCarros+"}");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/adm/PainelLoja.jsp");
        dispatcher.forward(request, response);
    }
}
