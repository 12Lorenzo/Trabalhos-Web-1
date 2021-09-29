<%--
  Created by IntelliJ IDEA.
  User: marc
  Date: 24/09/2021
  Time: 01:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fmt:bundle basename="messages">
<form action="${pageContext.request.contextPath}/decisao/aceito/${requestScope.id}" method="post">

    <input hidden type="number" name="id" value="${requestScope.id}">
    <label><fmt:message key="reuniao"/></label>
    <input type="datetime-local" required="required" id="reuniao" name="reuniao"><br>
    <label><fmt:message key="link"/></label>
    <input type="text" required="required" name="link" placeholder="link da reunião"><br>
    <label><fmt:message key="mensagem"/></label>
    <input type="text" required="required" name="mensagem" placeholder="mensagem"><br>

    <input type="submit" value="Enviar" ><br>

</form>
</fmt:bundle>
</body>
</html>
