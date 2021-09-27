package br.ufscar.dsw1.katchau.controle;

import br.ufscar.dsw1.katchau.bean.BuscaPorModeloBean;
import br.ufscar.dsw1.katchau.dao.CarroDAO;
import br.ufscar.dsw1.katchau.entidade.Carro;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
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
        request.setCharacterEncoding("UTF-8");
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String nome = request.getParameter("term");

        Gson gsonBuilder = new GsonBuilder().create();
        List<String> carros = new ArrayList<>();
        BuscaPorModeloBean bean = new BuscaPorModeloBean();
        List<Carro> listaCarros = bean.getCarros(nome);
        for (Carro carro : listaCarros) {
            carro.setImagens(carro.getImages(getServletContext().getRealPath("upload")));
            carros.add(carro.toString());
        }

        System.out.println(gsonBuilder.toJson(carros));
        response.getWriter().write(gsonBuilder.toJson(carros));
    }
}
