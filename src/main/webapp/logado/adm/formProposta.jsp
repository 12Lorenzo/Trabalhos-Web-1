<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="" method="${requestScope.formMethod}">
    <label for="id">id:</label><br>
    <input ${requestScope.formMethod == "post"? "":"disabled"}
            type="text" id="id" name="id" value=
            "${(requestScope.proposta == null || requestScope.formMethod == "post"?"":requestScope.proposta.id)}"><br>

    <label for="status">Status:</label><br>
    <input ${requestScope.formMethod == "delete" ? "disabled":""}
            type="text" id="status" name="status" value=
            "${(requestScope.proposta == null || requestScope.formMethod == "post"?"":requestScopeproposta.status)}"><br>

    <label for="data">Data:</label><br>
    <input ${requestScope.formMethod == "delete" ? "disabled":""}
            type="date" id="data" name="data" value=
            "${(requestScope.proposta == null || requestScope.formMethod == "post"?"":requestScope.proposta.data)}"><br>

    <label for="valor">Valor:</label><br>
    <input ${requestScope.formMethod == "delete" ? "disabled":""}
            type="number"  id="valor" name="valor" value="${requestScope.proposta == null ?"" :requestScope.proposta.valor}"><br>

    <label for="cpf">CPF:</label><br>
    <input ${requestScope.formMethod == "delete" ? "disabled":""}
            type="text" id="cpf" name="cpf" value="${requestScope.formMethod == "post" || requestScope.proposta == null?"":requestScope.proposta.cpf}"

    <label for="cnpj">CNPJ:</label><br>
    <input ${requestScope.formMethod == "delete" ? "disabled":""}
            type="text" id="cnpj" name="cnpj" value="${requestScope.formMethod == "post" || requestScope.proposta == null?"":requestScope.proposta.cnpj}"

    <label for="carro_id">Carro_Id:</label><br>
    <input ${requestScope.formMethod == "delete" ? "disabled":""}
            type="text" id="carro_id" name="carro_id" value="${requestScope.formMethod == "post" || requestScope.proposta == null?"":requestScope.proposta.carro_id}"

    <label for="condPag">CondPag:</label><br>
    <input ${requestScope.formMethod == "delete" ? "disabled":""}
            type="text" id="condPag" name="condPag" value="${requestScope.formMethod == "post" || requestScope.proposta == null?"":requestScope.proposta.condPag}"



    ><br>

    <input type="submit" value="Submit"><br>
</form>

</body>
</html>
