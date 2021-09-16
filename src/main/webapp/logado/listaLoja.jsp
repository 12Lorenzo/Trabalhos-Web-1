<%--
  Created by IntelliJ IDEA.
  User: loren
  Date: 15/09/2021
  Time: 19:09
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
        <td>cnpj</td>
        <td>descricao</td>
    </tr>
    <c:forEach var="loja" items="${listaLojas}">

        <td>
            <c:out value="${loja.cnpj}"/>
        </td>
            <td><c:out value="${loja.descricao}"/></td>

        </tr>
    </c:forEach>

</table>
</body>
</html>
