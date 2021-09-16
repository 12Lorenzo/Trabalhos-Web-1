<%--
  Created by IntelliJ IDEA.
  User: loren
  Date: 16/09/2021
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <c:forEach var="proposta" items="${listaProposta}">

        <td>
            <c:out value="${proposta.id}"/>
        </td>
            <td><c:out value="${proposta.status}"/></td>
            <td><c:out value="${proposta.data}"/></td>
            <td><c:out value="${proposta.valor}"/></td>
            <td><c:out value="${proposta.cnpj}"/></td>
            <td><c:out value="${proposta.carro_id}"/></td>
            <td><c:out value="${proposta.candPag}"/></td>

        </tr>
    </c:forEach>

</table>
</body>
</html>
