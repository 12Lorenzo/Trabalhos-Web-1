package br.ufscar.dsw1.katchau.controle;

//Faz as operações.

import br.ufscar.dsw1.katchau.dao.CarroDAO;
import br.ufscar.dsw1.katchau.entidade.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static br.ufscar.dsw1.katchau.Constants.*;
import static br.ufscar.dsw1.katchau.Constants.UPLOAD_DIRECTORY;

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
        req.setAttribute("formMethod", "post");
        criar(req, resp);
    }

    protected int mandarmagem( List<FileItem> formImg, HttpServletRequest request, HttpServletResponse response, long id) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int message = 0;

        if (ServletFileUpload.isMultipartContent(request)) {

            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(MEMORY_THRESHOLD);
            factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setFileSizeMax(MAX_FILE_SIZE);
            upload.setSizeMax(MAX_REQUEST_SIZE);
            String localPath = UPLOAD_DIRECTORY + File.separator + id;
            String uploadPath = getServletContext().getRealPath(localPath);
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            try {
                System.out.println("formItens " + formImg);
                System.out.println("formItenssize " + formImg.size());
                if (formImg != null && formImg.size() > 0) {
                    for (FileItem item : formImg) {
                        //todo conferir se eh uma imagem e limitar a apenas 10
                        if (!item.isFormField()) {
                            String fileName = new File(item.getName()).getName();
                            System.out.println("oi rsrs");
                            String filePath = uploadPath + File.separator + fileName;
                            File storeFile = new File(filePath);
                            item.write(storeFile);
                            request.getSession().setAttribute("message", "File " + fileName + " has uploaded successfully!");
                        }
                    }
                }
            } catch (Exception ex) {
                request.getSession().setAttribute("message", "There was an error: " + ex.getMessage());
                message = 6;
            }

        }
        return message;
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

                String cnpj ="", placa="", modelo="", chassi="";

                String ano_str="", km_str="", valor_str="", descricao="";

                DiskFileItemFactory factory = new DiskFileItemFactory();
                factory.setSizeThreshold(MEMORY_THRESHOLD);
                factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

                ServletFileUpload upload = new ServletFileUpload(factory);
                List<FileItem> formItems = upload.parseRequest(request);
                List<FileItem> formImg = new ArrayList<FileItem>();
                if (formItems != null && formItems.size() > 0) {
                    for (FileItem item : formItems) {
                        if (item.isFormField()) {
                            String fieldname = item.getFieldName();
                            String fieldvalue = item.getString();
                            switch (fieldname){
                                case  "placa":
                                    placa = fieldvalue;
                                    break;
                                case "modelo":
                                    modelo = fieldvalue;
                                    break;
                                case "chassi":
                                    chassi = fieldvalue;
                                    break;
                                case "descricao":
                                    descricao = fieldvalue;
                                    break;
                                case "ano":
                                    ano_str = fieldvalue;
                                    break;
                                case "km":
                                    km_str = fieldvalue;
                                    break;
                                case "valor":
                                    valor_str = fieldvalue;
                                    break;
                            }
                        }else {
                            formImg.add(item);
                        }
                    }
                }

                cnpj = loja.getCnpj();
                request.getParameter("placa");
                request.getParameter("modelo");
                request.getParameter("chassi");
                System.out.println("tamo não");


                int ano = Integer.parseInt(ano_str);
                float km= Float.parseFloat(km_str);
                float valor = Float.parseFloat(valor_str);
                System.out.println("tamo aq");
                Carro car = new Carro(cnpj, placa, modelo, chassi, descricao, ano, km, valor);
                long id_carro;
                id_carro = dao.insert(car);
                if (id_carro == -1){
                    result = 6;
                }

                result = mandarmagem(formImg, request, response, id_carro);


                System.out.println("Entrou para dar insert " + id_carro);
            }
        } catch(RuntimeException | FileUploadException e){
            //throw new ServletException(2);
            System.out.println("erro :" + e);
            result = 400;
        }
        request.setAttribute("erro", result);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/adm/erros.jsp");
        dispatcher.forward(request, response);
    }

}
