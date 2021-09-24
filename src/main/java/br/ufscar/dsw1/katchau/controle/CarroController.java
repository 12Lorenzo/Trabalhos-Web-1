package br.ufscar.dsw1.katchau.controle;

//Faz as operações.

import br.ufscar.dsw1.katchau.dao.CarroDAO;
import br.ufscar.dsw1.katchau.entidade.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="Carros", urlPatterns = "/carros/*")
public class CarroController extends HttpServlet {
    private CarroDAO dao;

    @Override
    public void init() {
        dao = new CarroDAO();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
//        Usuario currentUser = (Usuario) request.getSession().getAttribute("user");
//        if(currentUser != null && currentUser.getPapel() == 1) {
//            Long codigo = request.getParameter("id")==null?null:Long.valueOf(request.getParameter("id"));
//            Carro carro = dao.read(codigo);
//            String method = request.getParameter("method") == null? "post" : request.getParameter("method");
//            if (carro != null) {
//                request.setAttribute("formMethod",method);
//                request.setAttribute("carro", carro);
//                RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/adm/formCarro.jsp");
//                dispatcher.forward(request, response);
//            } else {
//                request.setAttribute("formMethod", "post");
//                RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/adm/formCarro.jsp");
//                dispatcher.forward(request, response);
//            }
//        }
//        else {
//            request.setAttribute("erro", "você não é loja, logue novamente");
//            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
//            dispatcher.forward(request, response);
//        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        //todo criar um carro
//        doGet(req,resp);
        req.setAttribute("formMethod", "post");
        criar(req, resp);
    }

    private void criar (HttpServletRequest request, HttpServletResponse response) {
        //RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/adm/formCarro.jsp");
        //dispatcher.forward(request, response);

        try{
            Loja loja = (Loja) request.getSession().getAttribute("loja");
            if(loja != null) {
                //cnpj, placa, modelo, chassi,  ano, km, descricao, valor
                String cnpj = loja.getCnpj();
                String placa = request.getParameter("placa");
                String modelo = request.getParameter("modelo");
                String chassi = request.getParameter("chassi");
                int ano = Integer.parseInt(request.getParameter("ano"));
                float km= Float.parseFloat(request.getParameter("km"));
                String descricao = request.getParameter("descricao");
                float valor = Float.parseFloat(request.getParameter("valor"));

                Carro car = new Carro(cnpj, placa, modelo, chassi, descricao, ano, km, valor);
                int recebeDao;
                recebeDao = dao.insert(car);

                System.out.println("Entrou para dar insert" + recebeDao);
            }
        } catch(RuntimeException e){
            //throw new ServletException(2);
            return; //TODO Resolver isso por favor.
        }
    }

}
