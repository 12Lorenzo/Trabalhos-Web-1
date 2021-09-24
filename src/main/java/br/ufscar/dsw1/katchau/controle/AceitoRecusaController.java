package br.ufscar.dsw1.katchau.controle;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AceitoRecusaController", value = "/decisao/*")
public class AceitoRecusaController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        if(request.getRequestURI().contains("aceito")){
            //todo aceitar
        }else if(request.getRequestURI().contains("recusa")){
            //todo aceitar
        }
    }
}
