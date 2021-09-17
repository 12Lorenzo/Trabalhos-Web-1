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
        doPost(request,response);
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/listaUsuarios.jsp");
        dispatcher.forward(request, response);
    }
}
