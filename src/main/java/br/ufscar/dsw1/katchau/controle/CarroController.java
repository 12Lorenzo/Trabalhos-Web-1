package br.ufscar.dsw1.katchau.controle;

//Faz as operações.

import br.ufscar.dsw1.katchau.dao.CarroDAO;
import br.ufscar.dsw1.katchau.entidade.Carro;
import br.ufscar.dsw1.katchau.entidade.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(urlPatterns = "/carros/*")
public class CarroController extends HttpServlet {
    private CarroDAO dao;

    @Override
    public void init() {
        dao = new CarroDAO();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Usuario currentUser = (Usuario) request.getSession().getAttribute("user");
        if(currentUser != null && currentUser.getPapel() == 1) {
            Long codigo = request.getParameter("id")==null?null:Long.valueOf(request.getParameter("id"));
            Carro carro = dao.read(codigo);
            String method = request.getParameter("method") == null? "post" : request.getParameter("method");
            if (carro != null) {
                request.setAttribute("formMethod",method);
                request.setAttribute("carro", carro);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/adm/formCarro.jsp");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("formMethod", "post");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/adm/formCarro.jsp");
                dispatcher.forward(request, response);
            }
        }
        else {
            request.setAttribute("erro", "você não é adm, logue novamente");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        doGet(req,resp);
    }
}
