<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%= request.getAttribute("erro") == null ? "" : request.getAttribute("erro") %>
<form action="./Validator" method="post">
    <label for="email">E-mail</label><br>
    <input type="email" id="email" name="email" value=""><br>
    <label for="password">Password</label><br>
    <input type="password" id="password" name="password" value=""><br><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
