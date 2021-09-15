package br.ufscar.dsw1.katchau.controle;

import br.ufscar.dsw1.katchau.dao.AuthDAO;
import br.ufscar.dsw1.katchau.dao.CarroDAO;
import br.ufscar.dsw1.katchau.entidade.Carro;
import br.ufscar.dsw1.katchau.entidade.Usuario;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Validator", value = "/Validator")
public class Validator extends HttpServlet {
    private AuthDAO dao;

    @Override
    public void init() {
        dao = new AuthDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Usuario result = password != null && email != null ?dao.validate(email, password): null;

        System.out.println("não é isso ai");
        if(result != null){
            request.setAttribute("erro", "bem vindo " + result.getNome());
            request.getSession().setAttribute("user", result);
            RequestDispatcher dispatcher = request.getRequestDispatcher("./login.jsp");
            dispatcher.forward(request, response);
        } else{
            request.setAttribute("erro", "tem erro");
            RequestDispatcher dispatcher = request.getRequestDispatcher("./login.jsp");
            dispatcher.forward(request, response);
        }
    }
}
