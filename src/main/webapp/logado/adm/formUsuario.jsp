<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="" method="${requestScope.get("formMethod") == null ?"post":requestScope.get("formMethod")}">
    <label for="codigo">CPF/CNPJ:</label><br>
    <input <%= request.getAttribute("formMethod") != "post"? "disabled":"" %>
            type="text" id="codigo" name="codigo" value=
            "${(requestScope.usuario == null || requestScope.formMethod == "post"?"":requestScope.usuario.codigo)}"><br>
    <label for="email">E-mail:</label><br>

    <input <%= request.getAttribute("formMethod") == "delete"? "disabled":"" %>
            type="email" id="email" name="email" value=
            "${(requestScope.usuario == null || requestScope.formMethod == "post"?"":requestScope.usuario.email)}"><br>
    <label for="nome">Nome:</label><br>

    <input <%= request.getAttribute("formMethod") == "delete"? "disabled":"" %>
            type="text" id="nome" name="nome" value=
            "${(requestScope.usuario == null || requestScope.formMethod == "post"?"":requestScope.usuario.senha)}"><br>
    <label for="adm">É adm?:</label><br>

    <input <%= request.getAttribute("formMethod") == "delete"? "disabled":"" %>
            type="checkbox" id="adm" name="adm" ${requestScope.formMethod == "post" ||requestScope.usuario == null || requestScope.usuario.adm==false ? "" : "checked"}><br>
    <label for="senha">Senha:</label><br>

    <input <%= request.getAttribute("formMethod") == "delete"? "disabled":"" %>
            type="text" id="senha" name="senha" value="${requestScope.formMethod == "post" || requestScope.usuario == null?"":requestScope.usuario.senha}"

    ><br>

    <input type="submit" value="Submit"><br>
</form>
</body>
</html>
