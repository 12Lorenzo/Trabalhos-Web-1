package br.ufscar.dsw1.katchau.controle;

//Faz as operações.

import br.ufscar.dsw1.katchau.dao.ClienteDAO;
import br.ufscar.dsw1.katchau.dao.PropostaDAO;
import br.ufscar.dsw1.katchau.entidade.Cliente;
import br.ufscar.dsw1.katchau.entidade.Proposta;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/proposta/*")
public class PropostaController extends HttpServlet {


    @Override
    public void init() {
        cli = new ClienteDAO();
        dao = new PropostaDAO();
    }

    private ClienteDAO cli;
    private PropostaDAO dao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lista(request, response);
    }

    private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cliente auxCli = cli.retornaCli("000.000.001");
        System.out.println(auxCli);
        if(auxCli != null) {
            List<Proposta> listaPropostas = dao.read(auxCli); //Não esta funcionando
            request.setAttribute("listaPropostas", listaPropostas);
            System.out.println("-->" + listaPropostas.toString());
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/listaProposta.jsp");
        dispatcher.forward(request, response);



    }

}
