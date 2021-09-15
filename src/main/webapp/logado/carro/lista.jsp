<%--
  Created by IntelliJ IDEA.
  User: marc
  Date: 15/09/2021
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
aaaaaaaaaaaaaaaaaaaaaaaa
<table border="1">
    <c:forEach var="carro" items="${requestScope.listaCarros}">
        <tr>
            <td>${carro.id}</td>
            <td>${carro.modelo}</td>

        </tr>
    </c:forEach>

</table>
</body>
</html>
