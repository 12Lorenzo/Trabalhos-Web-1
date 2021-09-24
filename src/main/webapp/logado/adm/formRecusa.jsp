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

<form action="${pageContext.request.contextPath}/decisao/recusa" method="post">
    <input type="number" name="valor" placeholder="Valor da contra proposta"><br>
    <input type="text" name="descricao" placeholder="Descricao da contra proposta"><br>

    <input type="submit" value="Enviar" ><br>

</form>
</body>
</html>
