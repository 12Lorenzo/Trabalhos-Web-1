package br.ufscar.dsw1.katchau.controle;

//Faz as operações.

import br.ufscar.dsw1.katchau.dao.ClienteDAO;
import br.ufscar.dsw1.katchau.entidade.Cliente;
import br.ufscar.dsw1.katchau.entidade.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@WebServlet(urlPatterns = "/cliente/*")
public class ClienteController extends HttpServlet {
    private ClienteDAO dao;

    @Override
    public void init() { dao = new ClienteDAO(); }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String[] parsing = request.getRequestURI().split("/");
        String action;
        if (parsing.length > 2){
            action = parsing[parsing.length - 2];
            switch (action){
                case "put":
                case "delete":
                    Cliente cli = dao.retornaCli(parsing[parsing.length-1]);
                    if (cli != null){
                        request.setAttribute("formMethod", action);
                        request.setAttribute("cliente", cli);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/adm/formCliente.jsp");
                        dispatcher.forward(request, response);
                    }
                    break;
                case "post":
                    request.setAttribute("formMethod", "post");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/adm/formCliente.jsp");
                    dispatcher.forward(request, response);
                    break;
                default:
                    break;
            }
        }
    }

    private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        List<Cliente> listaClientes = dao.read();
        request.setAttribute("listaClientes", listaClientes);
        System.out.println("-->" + listaClientes.toString());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/listas/listaCliente.jsp");
        dispatcher.forward(request, response);
    }

    private boolean verifier(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Usuario user = (Usuario) request.getSession().getAttribute("user");
        if(user.getPapel() != 1){
            request.setAttribute("erro", 5);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/adm/erros.jsp");
            dispatcher.forward(request, response);
            return false;
        }
        return true;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String[] parsing = req.getRequestURI().split("/");
        String action;
        if (parsing.length > 2){
            action = parsing[parsing.length - 1];
            if (action.equals("put")){
                doPut(req,resp);
                return;
            }else if(action.equals("delete")) {
                doDelete(req, resp);
                return;
            }
        }


        Cliente cli = organizar(req);
        int result;
        if (cli == null){
            result = 400;
        }else {
            Cliente teste = dao.retornaCli(cli.getCpf());
            if (teste != null)
                result = 6;
            else
                result = dao.insert(cli);
        }

        req.setAttribute("erro", result);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/logado/adm/erros.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cliente cli = organizar(req);
        int result;
        if (cli == null){
            result = 400;
        }else {
            Cliente teste = dao.retornaCli(cli.getCpf());
            if (teste != null)
                result = dao.delete(cli.getCpf());
            else
                result = 7;
        }

        req.setAttribute("erro", result);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/logado/adm/erros.jsp");
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cliente cli = organizar(req);
        int result;
        if (cli == null){
            result = 400;
        }else {
            Cliente teste = dao.retornaCli(cli.getCpf());
            if (teste != null)
                result  = dao.update(cli);
            else
                result = 7;
        }

        req.setAttribute("erro", result);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/logado/adm/erros.jsp");
        dispatcher.forward(req, resp);

    }

    private Cliente organizar(HttpServletRequest req) {

        String cpf = (String) req.getParameter("cpf");
        String telefone = (String) req.getParameter("telefone");
        String sexo = (String) req.getParameter("sexo");
        String nascimento = (String) req.getParameter("nascimento");

        Date date1;
        try {
            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(nascimento);
        }
        catch (java.text.ParseException e){
            return  null;
        }

        System.out.println(cpf);
        System.out.println(telefone);
        System.out.println(sexo);
        System.out.println(nascimento);
        if (cpf == null || telefone == null || sexo == null || nascimento == null)
            return null;

        return new Cliente(cpf,telefone,sexo,date1);
    }
}
