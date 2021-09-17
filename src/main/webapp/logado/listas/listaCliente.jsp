<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<link rel="stylesheet" href="./css/listas.css" />
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" id="tabela">
    <tr>

    <tr>
        <td id="CelTb">cpf</td>
        <td id="CelTb">telefone</td>
        <td id="CelTb">sexo</td>
        <td id="CelTb">nacimento</td>
    </tr>
    <c:forEach var="cliente" items="${listaClientes}">

        <td id="CelTb">
            <c:out value="${cliente.cpf}"/>
        </td>
            <td id="CelTb"><c:out value="${cliente.telefone}"/></td>
            <td id="CelTb"><c:out value="${cliente.sexo}"/></td>
            <td id="CelTb"><c:out value="${cliente.nascimento}"/></td>


        </tr>
    </c:forEach>

</table>
</body>
</html>
