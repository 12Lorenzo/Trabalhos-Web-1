package br.ufscar.dsw1.katchau.controle;

import br.ufscar.dsw1.katchau.dao.CarroDAO;
import br.ufscar.dsw1.katchau.dao.ClienteDAO;
import br.ufscar.dsw1.katchau.dao.PropostaDAO;
import br.ufscar.dsw1.katchau.dao.UsuarioDAO;
import br.ufscar.dsw1.katchau.entidade.Cliente;
import br.ufscar.dsw1.katchau.entidade.EmailService;
import br.ufscar.dsw1.katchau.entidade.Proposta;
import br.ufscar.dsw1.katchau.entidade.Usuario;

import javax.mail.internet.InternetAddress;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;


//Faz o controle das ações de Aceito e Recurso.

@WebServlet(name = "AceitoRecusaController", value = "/decisao/*")
public class AceitoRecusaController extends HttpServlet {

    @Override
    public void init() {
        dao = new PropostaDAO();
        usrDao = new UsuarioDAO();
    }
    private UsuarioDAO usrDao;
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
        String link = request.getParameter("link");
        String datahora = request.getParameter("reuniao");
        String mensagem = request.getParameter("mensagem");

        String valor = request.getParameter("valor");
        String descricao = request.getParameter("descricao");

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
            }else {
                Usuario usr = usrDao.read(proposta.getCpf());
                if (usr == null){
                    result = 3;
                    System.out.println("não foi possivel encontrar o dono da proposta");
                }else if (request.getRequestURI().contains("aceito")) {
                    if(link==null || link.isEmpty()|| datahora==null || datahora.isEmpty()|| mensagem==null|| mensagem.isEmpty()){
                        result = 400;
                        System.out.println("o formulário não foi preenchido corretamente");
                    }else {
                        result = dao.aceitarRecusar(proposta, 1);
                        if(result == 0) {
                            proposta.setStatus(1);
                            String body = "Sua proposta :" + proposta.toString() + " foi aceita.";
                            body += "\nA reunião será " + datahora + " no link: " + link + "\nMensagem do vendedor: " + mensagem;
                            result = sendEmail(usr.getNome(), usr.getEmail(), "Sua propósta foi aceita!!", body);
                        }
                    }
                } else if (request.getRequestURI().contains("recusa")) {
                    result = dao.aceitarRecusar(proposta, 2);
                    if(result == 0) {
                        proposta.setStatus(2);
                        String body = "Sua proposta :" + proposta.toString() + " foi recusada.";
                        body = body + ((valor == null || valor.isEmpty()) ? "" : ("\nA contra proposta tem o valor de : R$ " + valor));
                        body = body + "\nDescrição: " + descricao;
                        result = sendEmail(usr.getNome(), usr.getEmail(), "Sua propósta foi recusada :(", body);
                    }
                } else{
                    System.out.println("algo está errado com o link");
                }
            }
        }
        request.setAttribute("erro", result);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/adm/erros.jsp");
        dispatcher.forward(request, response);
    }

    int sendEmail(String name, String email, String subject, String body) throws IOException {
        EmailService service = new EmailService();
        Properties prop = new Properties();
        InputStream is = AceitoRecusaController.class.getClassLoader().getResourceAsStream("config.properties");

        if (is != null) {
            prop.load(is);
        } else {
            System.out.println("Não foi possivel ler as credenciais de login do email smtp.");
            return 10;
        }
        InternetAddress from = new InternetAddress(prop.getProperty("username"), "Katchau");
        InternetAddress to = new InternetAddress(email, name);


        // Envio sem anexo
        return service.send(from, to, subject, body);
    }
}
