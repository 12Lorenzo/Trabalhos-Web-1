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
        req.setAttribute("formMethod", "post");
        criar(req, resp);
    }

    private void criar (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/adm/formCarro.jsp");
        //dispatcher.forward(request, response);
        int result = 0;
        try{
            Loja loja = (Loja) request.getSession().getAttribute("loja");
            System.out.println("loja = "+loja);
            if(loja != null) {
                //cnpj, placa, modelo, chassi,  ano, km, descricao, valor
                String cnpj = loja.getCnpj();
                String placa = request.getParameter("placa");
                String modelo = request.getParameter("modelo");
                String chassi = request.getParameter("chassi");
                System.out.println("tamo não");

                System.out.println(request.getParameter("ano"));
                System.out.println(request.getParameter("km"));
                System.out.println(request.getParameter("valor"));
                System.out.println(request.getAttributeNames());

                String descricao = request.getParameter("descricao");
                int ano = Integer.parseInt(request.getParameter("ano"));
                float km= Float.parseFloat(request.getParameter("km"));
                float valor = Float.parseFloat(request.getParameter("valor"));
                System.out.println("tamo aq");
                Carro car = new Carro(cnpj, placa, modelo, chassi, descricao, ano, km, valor);
                long id_carro;
                id_carro = dao.insert(car);
                if (id_carro == -1){
                    result = 6;
                }

                //todo upload das imagens



                System.out.println("Entrou para dar insert " + id_carro);
            }
        } catch(RuntimeException e){
            //throw new ServletException(2);
            System.out.println("erro :" + e);
            result = 400;
        }
        request.setAttribute("erro", result);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/adm/erros.jsp");
        dispatcher.forward(request, response);
    }

}
