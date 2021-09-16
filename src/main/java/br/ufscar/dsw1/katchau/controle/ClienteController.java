package br.ufscar.dsw1.katchau.controle;

//Faz as operações.

import br.ufscar.dsw1.katchau.dao.ClienteDAO;
import br.ufscar.dsw1.katchau.entidade.Cliente;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = "/cliente/*")
public class ClienteController extends HttpServlet {
    private ClienteDAO dao;

    @Override
    public void init() { dao = new ClienteDAO(); }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lista(request, response);
    }

    private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Cliente> listaClientes = dao.read();
        request.setAttribute("listaClientes", listaClientes);
        System.out.println("-->" + listaClientes.toString());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/listaCliente.jsp");
        dispatcher.forward(request, response);
    }
}
