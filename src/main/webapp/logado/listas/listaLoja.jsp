
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
