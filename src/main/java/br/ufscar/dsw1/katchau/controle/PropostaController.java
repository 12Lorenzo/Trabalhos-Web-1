package br.ufscar.dsw1.katchau.controle;

//Faz as operações.

import br.ufscar.dsw1.katchau.dao.CarroDAO;
import br.ufscar.dsw1.katchau.dao.ClienteDAO;
import br.ufscar.dsw1.katchau.dao.PropostaDAO;
import br.ufscar.dsw1.katchau.entidade.Cliente;
import br.ufscar.dsw1.katchau.entidade.Proposta;
import br.ufscar.dsw1.katchau.entidade.Usuario;
import br.ufscar.dsw1.katchau.entidade.Carro;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebServlet(urlPatterns = "/proposta/*")
public class PropostaController extends HttpServlet {


    @Override
    public void init() {
        cli = new ClienteDAO();
        dao = new PropostaDAO();
        carroDAO = new CarroDAO();
    }

    private ClienteDAO cli;
    private CarroDAO carroDAO;
    private PropostaDAO dao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] list  = request.getRequestURI().split("/");
        String id_str = list[list.length -1];
        Long id;
        try{
            id = Long.parseLong(id_str);
            form(request, response);
        }catch (NumberFormatException e){
            request.setAttribute("erro", 404);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/adm/erros.jsp");
            dispatcher.forward(request, response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] list  = request.getRequestURI().split("/");
        String id_str = list[list.length -1];
        Long id;
        try{
            id = Long.parseLong(id_str);
            Carro carro = carroDAO.read(id);
            Cliente cliente = (Cliente) request.getSession().getAttribute("cliente");
            String valor_str = (String) request.getParameter("valor");
            String cond = (String) request.getParameter("cond");
            float valor = Float.parseFloat(valor_str);
            int result = 0;
            List<Proposta> propostasDoCliente = dao.read(cliente);
            for (Proposta current : propostasDoCliente) {
                if (Objects.equals(current.getCarro_id(), id) && current.getStatus() == 0) {
                    result = 2;
                    break;
                }
            }
            System.out.println(valor);
            System.out.println(cond);
            System.out.println(carro.toString());
            System.out.println(cliente.toString());
            result = result == 0? dao.insert(cliente,carro,valor,cond): result;
            request.setAttribute("erro", result);

        }catch (NumberFormatException e){
            request.setAttribute("erro", 404);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/adm/erros.jsp");
        dispatcher.forward(request, response);
    }

    private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cliente auxCli = cli.retornaCli("000.000.001");
        System.out.println(auxCli);
        if(auxCli != null) {
            List<Proposta> listaPropostas = dao.read(auxCli); //Não esta funcionando
            request.setAttribute("listaPropostas", listaPropostas);
            System.out.println("-->" + listaPropostas.toString());
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/listas/listaProposta.jsp");
        dispatcher.forward(request, response);

    }


    protected void form(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("formMethod", "post");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/adm/formProposta.jsp");
        dispatcher.forward(request, response);
    }
}
