
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <td>id</td>
        <td>status</td>
        <td>data</td>
        <td>valor</td>
        <td>cnpj</td>
        <td>carro_id</td>
        <td>condPag</td>
    </tr>

    <c:forEach var="proposta" items="${listaPropostas}">

        <td>
            <c:out value="${proposta.id}"/>
        </td>
            <td><c:out value="${proposta.status}"/></td>
            <td><c:out value="${proposta.data}"/></td>
            <td><c:out value="${proposta.val}"/></td>
            <td><c:out value="${proposta.cpf}"/></td>
            <td><c:out value="${proposta.cnpj}"/></td>
            <td><c:out value="${proposta.carro_id}"/></td>
            <td><c:out value="${proposta.condPag}"/></td>

        </tr>
    </c:forEach>

</table>
</body>
</html>
