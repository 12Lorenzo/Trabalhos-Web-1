package br.ufscar.dsw1.katchau.controle;

//Faz as operações.

import br.ufscar.dsw1.katchau.dao.AuthDAO;
import br.ufscar.dsw1.katchau.dao.UsuarioDAO;
import br.ufscar.dsw1.katchau.entidade.Loja;
import br.ufscar.dsw1.katchau.entidade.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Usuario", value = "/usuario/*")
public class UsuarioController extends HttpServlet {
    private UsuarioDAO dao;

    @Override
    public void init() {
        dao = new UsuarioDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario currentUser = (Usuario) request.getSession().getAttribute("user");
        if(currentUser != null && currentUser.getPapel() == 1) {
            String codigo = request.getParameter("codigo");
            Usuario user = dao.read(codigo);
            String method = request.getParameter("method") == null? "post" : request.getParameter("method");
            System.out.println("ok adm");
            if (user != null) {

                System.out.println("user ->"+ user);
                request.setAttribute("formMethod",method);
                request.setAttribute("usuario", user);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/adm/formUsuario.jsp");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("formMethod", "post");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/adm/formUsuario.jsp");
                dispatcher.forward(request, response);
            }
        }
        else {
            System.out.println("nao adm");
            request.setAttribute("erro", "você não é adm, logue novamente");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("formMethod", "post");
        Usuario user = dao.getAll().get(0);
        request.setAttribute("usuario", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("./logado/adm/formUsuario.jsp");
        dispatcher.forward(request, response);
    }

    private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Usuario> listaUsuarios = dao.getAll();
        request.setAttribute("listaUsuarios", listaUsuarios);
        System.out.println("Usuarios-->" + listaUsuarios.toString());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/listas/listaUsuarios.jsp");
        dispatcher.forward(request, response);
    }
}
