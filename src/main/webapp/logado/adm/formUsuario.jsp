<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<p>
<%--    <%= request.getParameter("nome")%>--%>
<%--    <%= request.getParameter("email")%>--%>
<%--    <%= request.getAttribute("formMethod")%>--%>

</p>
<%--<%= request.setAttribute("formMethod", (request.getAttribute("formMethod") == null? "post": request.getAttribute("formMethod"))) %>--%>
<form action="" method="${requestScope.formMethod}">
    <label for="codigo">CPF/CNPJ:</label><br>
    <input ${requestScope.formMethod == "post"? "":"readonly=\"readonly\""}
            type="text" id="codigo" name="codigo" value=
            "${(requestScope.usuario == null || requestScope.formMethod.equals("post")?"":requestScope.usuario.codigo)}"><br>

    <label for="email">E-mail:</label><br>
    <input ${requestScope.formMethod.equals("delete") ? "readonly=\"readonly\"":""}
            type="email" id="email" name="email" value=
            "${(requestScope.usuario == null || requestScope.formMethod.equals("post")?"":requestScope.usuario.email)}"><br>

    <label for="nome">Nome:</label><br>
    <input ${requestScope.formMethod.equals("delete") ? "readonly=\"readonly\"":""}
            type="text" id="nome" name="nome" value=
            "${(requestScope.usuario == null || requestScope.formMethod.equals("post")?"":requestScope.usuario.senha)}"><br>

    <label for="papel">Papel:</label><br>
    <input ${requestScope.formMethod.equals("delete") ? "readonly=\"readonly\"":""}
            type="number" min=0 max=3 id="papel" name="papel" value="${requestScope.usuario == null ?"" :requestScope.usuario.papel}"><br>

    <label for="senha">Senha:</label><br>
    <input ${requestScope.formMethod.equals("delete") ? "readonly=\"readonly\"":""}
            type="text" id="senha" name="senha" value="${requestScope.formMethod.equals("post") || requestScope.usuario == null?"":requestScope.usuario.senha}"

    ><br>

    <input type="submit" value="Submit"><br>
</form>
</body>
</html>
