<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="" method="post">

    <label for="valor">Valor:</label><br>
    <input type="number" step="0.01" id="valor" name="valor" value="0"><br>

    <label for="condPag">CondPag:</label><br>
    <input ${requestScope.formMethod == "delete" ? "disabled":""}
            type="text" id="condPag" name="condPag" value="${requestScope.formMethod == "post" || requestScope.proposta == null?"":requestScope.proposta.condPag}"

    ><br>

    <input type="submit" value="Submit"><br>
</form>

</body>
</html>
