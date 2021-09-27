package br.ufscar.dsw1.katchau.controle;

import br.ufscar.dsw1.katchau.dao.CarroDAO;
import br.ufscar.dsw1.katchau.dao.ClienteDAO;
import br.ufscar.dsw1.katchau.dao.PropostaDAO;
import br.ufscar.dsw1.katchau.entidade.Proposta;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "AceitoRecusaController", value = "/decisao/*")
public class AceitoRecusaController extends HttpServlet {

    @Override
    public void init() {
        dao = new PropostaDAO();
    }

    private PropostaDAO dao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] parsing = request.getRequestURI().split("/");
        String id_str = parsing[parsing.length-1];

        request.setAttribute("id", id_str);


        if(request.getRequestURI().contains("aceito")){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/adm/formAceito.jsp");
            dispatcher.forward(request, response);
        }else if(request.getRequestURI().contains("recusa")){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/adm/formRecusa.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id_str = request.getParameter("id");
        System.out.println("começando a fazer a troca de estado da proposta");
        int result = 0;
        long id = (long) 0;
        try {
            id = Long.parseLong(id_str);
        }catch (NumberFormatException e){
            //deu ruim
            result = 400;
            System.out.println("não foi possivel fazer o parsing de {"+id_str+"} para long");
            System.out.println(e);
        }
        if (result == 0) {
            Proposta proposta = dao.read(id);
            if (proposta == null) {
                result = 400;
                System.out.println("não foi possivel encontrar a proposta");
            }
            if (result == 0 && request.getRequestURI().contains("aceito")) {
                result = dao.aceitarRecusar(proposta, 1);
                //todo mandar email
            } else if (result == 0 && request.getRequestURI().contains("recusa")) {
                result = dao.aceitarRecusar(proposta, 2);
                //todo mandar email
            }else{
                System.out.println("algo está errado com o link");
            }
        }
        request.setAttribute("erro", result);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/adm/erros.jsp");
        dispatcher.forward(request, response);
    }
}
