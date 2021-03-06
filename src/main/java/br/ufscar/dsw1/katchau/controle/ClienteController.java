package br.ufscar.dsw1.katchau.controle;

//Faz as operações.

import br.ufscar.dsw1.katchau.dao.ClienteDAO;
import br.ufscar.dsw1.katchau.dao.UsuarioDAO;
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


//Faz o controle de cliente

@WebServlet(urlPatterns = "/cliente/*")
public class ClienteController extends HttpServlet {
    private ClienteDAO dao;
    private UsuarioDAO usrDao;

    @Override
    public void init() { dao = new ClienteDAO();usrDao = new UsuarioDAO();}


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
                    Usuario usr = usrDao.read(parsing[parsing.length-1]);
                    Cliente cli = dao.retornaCli(parsing[parsing.length-1]);
                    if (cli != null && usr != null){
                        request.setAttribute("formMethod", action);
                        request.setAttribute("cliente", cli);
                        request.setAttribute("cliente_usr", usr);
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
            action = parsing[parsing.length - 2];
            if (action.equals("put")){
                doPut(req,resp);
                return;
            }else if(action.equals("delete")) {
                doDelete(req, resp);
                return;
            }
        }


        System.out.println("estou fazendo post");
        Cliente cli = organizar(req);
        Usuario usr = organizar_usr(req);
        int result;

        if (cli == null || usr == null){
            result = 400;
        }else {
            Usuario teste_usr = usrDao.read(cli.getCpf());
            Cliente teste = dao.retornaCli(cli.getCpf());
            if (teste != null || teste_usr != null)
                result = 6;
            else{
                result = usrDao.insert(usr);
                if (result == 0)
                    result = dao.insert(cli);
            }
        }

        req.setAttribute("erro", result);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/logado/adm/erros.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cliente cli = organizar(req);
        Usuario usr = organizar_usr(req);

        System.out.println("estou fazendo delete");
        int result;
        if (cli == null || usr == null){
            result = 400;
        }else {
            Usuario teste_usr = usrDao.read(cli.getCpf());
            Cliente teste = dao.retornaCli(cli.getCpf());
            if (teste != null && teste_usr != null)
                result = usrDao.delete(cli.getCpf());
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
        Usuario usr = organizar_usr(req);
        System.out.println("estou fazendo put");
        String[] parsing = req.getRequestURI().split("/");
        int result;
        if (cli == null || usr == null){
            result = 400;
        }else {

            Usuario teste_usr = usrDao.read(parsing[parsing.length - 1]);
            Cliente teste = dao.retornaCli(parsing[parsing.length - 1]);
            if (teste != null && teste_usr != null) {
                result = usrDao.update(parsing[parsing.length - 1], usr);
                if(result == 0)
                    result = dao.update(cli);
            }
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

        if (cpf == null || telefone == null || sexo == null || nascimento == null)
            return null;

        return new Cliente(cpf,telefone,sexo,date1);
    }

    private Usuario organizar_usr(HttpServletRequest req) {

        String cpf = (String) req.getParameter("cpf");
        String email = (String) req.getParameter("email");
        String senha = (String) req.getParameter("senha");
        String nome = (String) req.getParameter("nome");

        if (cpf == null || email == null || senha == null || nome == null)
            return null;

        return new Usuario(cpf,email, senha,3,nome);
    }
}
