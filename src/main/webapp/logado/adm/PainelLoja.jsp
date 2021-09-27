<%@ page import="static br.ufscar.dsw1.katchau.Constants.UPLOAD_DIRECTORY" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
    <title>Painel da Loja</title>
    <style>
        img {
            display: block;
            margin-left: auto;
            margin-right: auto;
            width: 10%;
        }
    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>

                                                                                                                                                                                                                                                                                                                                                                                                                                     </head>
<body>

<fmt:bundle basename="messages">

<a href="${pageContext.request.contextPath}/logado/adm/formCarro.jsp">Criar novo anuncio</a>

<c:forEach var="carro" items="${ListaCarros}" varStatus="loop">
    <table border="1"><tr><td>
    <br>
    <h1>Carro:</h1>

    <c:if test="${carro.getImages(pageContext.servletContext.getRealPath('upload')).size() > 0}">


        <div id="carouselExampleControls${carro.id}" class="carousel slide" data-bs-ride="carousel" style="width: 300px">
            <div class="carousel-inner">
                <c:forEach var="img" items="${carro.getImages(pageContext.servletContext.getRealPath('upload'))}" varStatus="loopimg">
                    <div class="carousel-item ${loopimg.index == 0? 'active':''}">
                        <img src="${img}" class="d-block w-100" height="200px" alt="...">
                    </div>
                </c:forEach>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls${carro.id}" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls${carro.id}" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>


    </c:if>
     <table border="1" style="width: 400px; border: 1px solid black">
    <tr>
        <td style="text-align: center">${carro.modelo}</td>
        <td style="text-align: center">${carro.placa}</td>
        <td style="text-align: center">${carro.chassi}</td>
        <td style="text-align: center">${carro.descricao}</td>
        <td style="text-align: center">${carro.ano}</td>
        <td style="text-align: center">${carro.km}</td>
        <td style="text-align: center">${carro.valor}</td>
    </tr>
    </table>
    <h2>Propostas abertas:</h2>
    <c:forEach var="proposta" items="${ListaPropostas.stream().filter(p -> p.status == 0 && p.carro_id == carro.id).toList()}">
        <table border="1" style="width: 400px; border: 1px solid black">
            <tr>
                <td>
                    <c:out value="${proposta.id}"/>
                </td>
                <td><c:out value="ABERTO"/></td>
                <td><c:out value="${proposta.data}"/></td>
                <td><c:out value="${proposta.val}"/></td>
                <td><c:out value="${proposta.condPag}"/></td>
                <td><a href="${pageContext.request.contextPath}/decisao/aceito/${proposta.id}">ACEITAR</a></td>
                <td><a href="${pageContext.request.contextPath}/decisao/recusa/${proposta.id}">RECUSAR</a></td>
            </tr>
        </table>
    </c:forEach>
    <h2>Propostas fechadas:</h2>
    <c:forEach var="proposta" items="${ListaPropostas.stream().filter(p -> p.status != 0 && p.carro_id == carro.id).toList()}">
        <table border="1" style="width: 400px; border: 1px solid black">
            <tr>
                <td>
                    <c:out value="${proposta.id}"/>
                </td>
                <td><c:out value="${proposta.status == 1 ? 'Aceito' : proposta.status == 0 ? 'Aberto' : 'Não Aceito'  }"/></td>
                <td><c:out value="${proposta.data}"/></td>
                <td><c:out value="${proposta.val}"/></td>
                <td><c:out value="${proposta.condPag}"/></td>
            </tr>
        </table>
    </c:forEach>
    </td></tr></table>
</c:forEach>
</fmt:bundle>
</body>
</html>
