package br.ufscar.dsw1.katchau.controle;

import br.ufscar.dsw1.katchau.dao.AuthDAO;
import br.ufscar.dsw1.katchau.dao.CarroDAO;
import br.ufscar.dsw1.katchau.dao.ClienteDAO;
import br.ufscar.dsw1.katchau.dao.LojaDAO;
import br.ufscar.dsw1.katchau.entidade.Carro;
import br.ufscar.dsw1.katchau.entidade.Cliente;
import br.ufscar.dsw1.katchau.entidade.Loja;
import br.ufscar.dsw1.katchau.entidade.Usuario;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Validator", value = "/Validator/*")
public class Validator extends HttpServlet {
    private AuthDAO dao;
    private LojaDAO lojaDAO;
    private ClienteDAO clienteDAO;

    @Override
    public void init() {
        dao = new AuthDAO();
        lojaDAO = new LojaDAO();
        clienteDAO = new ClienteDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getRequestURI();
        RequestDispatcher dispatcher;
        if (request.getSession()!= null && action.contains("logout")){
            request.getSession().invalidate();
            response.sendRedirect(request.getContextPath());
            return;
        }

        dispatcher = request.getRequestDispatcher("/login.jsp");

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Usuario result = password != null && email != null ? dao.validate(email, password): null;

        if(result != null){
            request.setAttribute("erro", "bem vindo " + result.getNome());
            request.getSession().setAttribute("user", result);

            if(result.getPapel() == 1){
                dispatcher = request.getRequestDispatcher("/adm");
            }
            else if (result.getPapel() == 2){
                Loja loja = (Loja) lojaDAO.read(result.getCodigo());
                request.getSession().setAttribute("loja", loja);
                dispatcher = request.getRequestDispatcher("/painel");
            }else if (result.getPapel() == 3){
                Cliente cliente = (Cliente) clienteDAO.retornaCli(result.getCodigo());
                request.getSession().setAttribute("cliente", cliente);
                dispatcher = request.getRequestDispatcher("/");
            }else {
                dispatcher = request.getRequestDispatcher("/login.jsp");
        }
            dispatcher.forward(request, response);
        } else{
            request.setAttribute("erro", "E-mail ou senha incorretos");
            dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        }
    }
}
