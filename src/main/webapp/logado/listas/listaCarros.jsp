<%--
  Created by IntelliJ IDEA.
  User: marc
  Date: 15/09/2021
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Title</title>
</head>
<body><br>
<a href="./Validator">Login</a>
<br>
<table border="1">
    <tr>

    <tr>
        <td>id</td>
        <td>cnpj</td>
        <td>placa</td>
        <td>modelo</td>
        <td>chassi</td>
        <td>descricao</td>
        <td>ano</td>
        <td>km</td>
        <td>valor</td>
    </tr>
    <c:forEach var="carro" items="${listaCarros}">

        <td>
            <c:out value="${carro.id}"/>
        </td>
            <td><c:out value="${carro.cnpj}"/></td>
            <td><c:out value="${carro.placa}"/></td>
            <td><c:out value="${carro.modelo}"/></td>
            <td><c:out value="${carro.chassi}"/></td>
            <td><c:out value="${carro.descricao}"/></td>
            <td><c:out value="${carro.ano}"/></td>
            <td><c:out value="${carro.km}"/></td>
            <td><c:out value="${carro.valor}"/></td>

        </tr>
    </c:forEach>

</table>
</body>
</html>
