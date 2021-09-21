<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<link href="${pageContext.request.contextPath}/listas.css" rel="stylesheet" type="text/css"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" class="tabela">
    <tr>

    <tr>
        <td class="celTb">cpf</td>
        <td class="celTb">telefone</td>
        <td class="celTb">sexo</td>
        <td class="celTb">nacimento</td>
    </tr>
    <c:forEach var="cliente" items="${listaClientes}">

        <td class="CelTb">
            <c:out value="${cliente.cpf}"/>
        </td>
            <td class="celTb"><c:out value="${cliente.telefone}"/></td>
            <td class="celTb"><c:out value="${cliente.sexo}"/></td>
            <td class="celTb"><c:out value="${cliente.nascimento}"/></td>


        </tr>
    </c:forEach>

</table>
</body>
</html>
