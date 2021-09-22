<%@ page import="static br.ufscar.dsw1.katchau.Constants.UPLOAD_DIRECTORY" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
    <title>Title</title>
    <style>
        img {
            display: block;
            margin-left: auto;
            margin-right: auto;
            width: 10%;
        }
    </style>
</head>
<body>
<a>Criar novo anuncio</a>

<c:forEach var="carro" items="${ListaCarros}" varStatus="loop">
    <br>
    <h1>Carro:</h1>
    <c:forEach var="carro_img" items="${carro.getImages(pageContext.servletContext.getRealPath('upload'))}" varStatus="loop">

        <img src="${carro_img}"/>
    </c:forEach><br>
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
                <td><c:out value="${proposta.status == 1 ? 'Aceito' : proposta.status == 0 ? 'Aberto' : 'Não Aceito'  }"/></td>
                <td><c:out value="${proposta.data}"/></td>
                <td><c:out value="${proposta.val}"/></td>
                <td><c:out value="${proposta.condPag}"/></td>
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

</c:forEach>
</body>
</html>
