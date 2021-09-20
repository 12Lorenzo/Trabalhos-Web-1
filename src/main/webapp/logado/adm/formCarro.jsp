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
    <label for="cnpj">CNPJ:</label><br>
    <input ${requestScope.formMethod == "post"? "":"disabled"}
            type="text" id="cnpj" name="cnpj" value=
            "${(requestScope.carro == null || requestScope.formMethod == "post"?"":requestScope.carro.cnpj)}"><br>

    <label for="placa">Placa:</label><br>
    <input ${requestScope.formMethod == "delete" ? "disabled":""}
            type="text" id="placa" name="placa" value=
            "${(requestScope.carro == null || requestScope.formMethod == "post"?"":requestScope.carro.placa)}"><br>


    <label for="modelo">Modelo:</label><br>
    <input ${requestScope.formMethod == "delete" ? "disabled":""}
            type="text" id="modelo" name="modelp" value=
            "${(requestScope.carro == null || requestScope.formMethod == "post"?"":requestScope.carro.modelo)}"><br>


    <label for="chassi">Chassi:</label><br>
    <input ${requestScope.formMethod == "delete" ? "disabled":""}
            type="text" id="chassi" name="chassi" value=
            "${requestScope.formMethod == null ?"" :requestScope.carro.chassi}"><br>


    <label for="ano">Ano:</label><br>
    <input ${requestScope.formMethod == "delete" ? "disabled":""}
            type="int" id="ano" name="ano" value=
            "${(requestScope.carro == null || requestScope.formMethod == "post"?"":requestScope.carro.ano)}"><br>


    <label for="km">Km:</label><br>
    <input ${requestScope.formMethod == "delete" ? "disabled":""}
            type="float" id="km" name="km" value=
            "${(requestScope.carro == null || requestScope.formMethod == "post"?"":requestScope.carro.km)}"><br>


    <label for="descricao">Descricao:</label><br>
    <input ${requestScope.formMethod == "delete" ? "disabled":""}
            type="text" id="descricao" name="descricao" value=
            "${(requestScope.carro == null || requestScope.formMethod == "post"?"":requestScope.carro.descricao)}"><br>


    <label for="valor">Valor:</label><br>
    <input ${requestScope.formMethod == "delete" ? "disabled":""}
            type="float" id="valor" name="valor" value=
            "${(requestScope.carro == null || requestScope.formMethod == "post"?"":requestScope.carro.valor)}"><br>




    <input type="submit" value="Submit"><br>
</form>
</body>
</html>
