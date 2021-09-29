<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<fmt:bundle basename="messages">

<form action="" method="post">

    <label for="valor"><fmt:message key="valor"/>:</label><br>
    <input type="number" required="required" step="0.01" id="valor" name="valor" value="0"><br>

    <label for="condPag"><fmt:message key="condPag"/>:</label><br>
    <input type="text" required="required" id="condPag" name="cond" value="">



    <br>

    <input type="submit" value="Submit">

    <br>
</form>
</fmt:bundle>
</body>
</html>
