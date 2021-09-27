<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/forms.css" />
<html>
<head>
    <title>Title</title>
</head>
<body>
<fmt:bundle basename="messages">
<%--Cliente(cpf, telefone, sexo, nascimento)--%>
<form action="${pageContext.request.contextPath}/cliente/${requestScope.get("formMethod")}/${requestScope.cliente_usr == null ? "*":requestScope.cliente_usr.codigo}" method="post">
    <label for="cpf">CPF:</label><br>
    <input class="inCampo" <%= request.getAttribute("formMethod").equals("delete") ? "readonly=\"readonly\"" :""%>
            type="text" id="cpf" name="cpf" value=
            "${(requestScope.cliente == null || requestScope.formMethod == "post"?"":requestScope.cliente.cpf)}"><br>

    <label for="nome">Nome:</label><br>
    <input class="inCampo" <%= request.getAttribute("formMethod").equals("delete") ? "readonly=\"readonly\"" :""%>
           type="text" id="nome" name="nome" value=
                   "${(requestScope.cliente_usr == null || requestScope.formMethod == "post"?"":requestScope.cliente_usr.nome)}"><br>

    <label for="nome">Email:</label><br>
    <input class="inCampo" <%= request.getAttribute("formMethod").equals("delete") ? "readonly=\"readonly\"" :""%>
           type="email" id="email" name="email" value=
                   "${(requestScope.cliente_usr == null || requestScope.formMethod == "post"?"":requestScope.cliente_usr.email)}"><br>
    <label for="nome">Senha:</label><br>
    <input class="inCampo" <%= request.getAttribute("formMethod").equals("delete") ? "readonly=\"readonly\"" :""%>
           type="password" id="senha" name="senha" value=
                   "${(requestScope.cliente_usr == null || requestScope.formMethod == "post"?"":requestScope.cliente_usr.senha)}"><br>


    <label for="telefone">telefone:</label><br>

    <input <%= request.getAttribute("formMethod").equals("delete")? "readonly=\"readonly\"":"" %>
            type="telefone" id="telefone" name="telefone" value=
            "${(requestScope.cliente == null || requestScope.formMethod == "post"?"":requestScope.cliente.telefone)}"><br>
    <label for="sexo">Sexo:</label><br>

    <input <%= request.getAttribute("formMethod").equals("delete")? "readonly=\"readonly\"":"" %>
            type="text" id="sexo" name="sexo" value=
            "${(requestScope.cliente == null || requestScope.formMethod == "post"?"":requestScope.cliente.sexo)}"><br>
    <label for="nascimento">Data de nascimento:</label><br>

    <input <%= request.getAttribute("formMethod").equals("delete")? "readonly=\"readonly\"":"" %>
            type="date" id="nascimento" name="nascimento" value="${requestScope.formMethod == "post" ||requestScope.cliente == null ? "" : requestScope.cliente.nascimento}"><br>

    <br>
    <br>
    <input type="submit" value="Submit"><br>
</form>
</fmt:bundle>
</body>
</html>
