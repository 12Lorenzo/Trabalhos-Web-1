<%--
  Created by IntelliJ IDEA.
  User: marc
  Date: 24/09/2021
  Time: 01:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--Formulario referente a recusar uma proposta.--%>

<html>
<head>
    <title>Title</title>
</head>
<body>

<fmt:bundle basename="messages">

<form action="${pageContext.request.contextPath}/decisao/recusa/${requestScope.id}" method="post">
    <input hidden type="number" name="id" value="${requestScope.id}">
    <fmt:message key="opcional"/>
    <label><fmt:message key="valor"/> </label>
    <input type="number" name="valor" placeholder="<fmt:message key="valor_contra"/>"><br>
    <label><fmt:message key="descricao"/></label>
    <input type="text" name="descricao" placeholder="<fmt:message key="descricao_contra"/>"><br>

    <input type="submit" value="Enviar" ><br>

</form>
</fmt:bundle>
</body>
</html>
