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
        <td>codigo</td>
        <td>email</td>
        <td>senha</td>
        <td>papel</td>
        <td>nome</td>
    </tr>

    <c:forEach var="usuario" items="${listaUsuarios}">

        <td>
            <c:out value="${usuario.codigo}"/>
        </td>
        <td><c:out value="${usuario.email}"/></td>
        <td><c:out value="${usuario.senha}"/></td>
        <td><c:out value="${usuario.papel}"/></td>
        <td><c:out value="${usuario.nome}"/></td>

        </tr>
    </c:forEach>

</table>


</body>
</html>
