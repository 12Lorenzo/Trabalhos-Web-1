package br.ufscar.dsw1.katchau.controle;

import br.ufscar.dsw1.katchau.dao.CarroDAO;
import br.ufscar.dsw1.katchau.entidade.Carro;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ResultadosController", value = "/results")
public class ResultadosController extends HttpServlet {
    private CarroDAO dao;

    @Override
    public void init() {
        dao = new CarroDAO();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lista(request, response);
    }

    private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Carro> listaCarros = dao.getAll();
        request.setAttribute("listaCarros", listaCarros);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/listas/listaCarros.jsp");
        dispatcher.forward(request, response);
    }
}
