<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>

    <tr>
        <td>cpf</td>
        <td>telefone</td>
        <td>sexo</td>
        <td>nacimento</td>
    </tr>
    <c:forEach var="cliente" items="${listaClientes}">

        <td>
            <c:out value="${cliente.cpf}"/>
        </td>
            <td><c:out value="${cliente.telefone}"/></td>
            <td><c:out value="${cliente.sexo}"/></td>
            <td><c:out value="${cliente.nascimento}"/></td>


        </tr>
    </c:forEach>

</table>
</body>
</html>
