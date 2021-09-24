<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/carros/" method="post">

    <label for="placa">Placa:</label><br>
    <input type="text" id="placa" name="placa" value=""><br>


    <label for="modelo">Modelo:</label><br>
    <input type="text" id="modelo" name="modelo" value=""><br>


    <label for="chassi">Chassi:</label><br>
    <input type="text" id="chassi" name="chassi" value=""><br>


    <label for="ano">Ano:</label><br>
    <input type="number" id="ano" name="ano" value=""><br>


    <label for="km">Km:</label><br>
    <input type="number" id="km" name="km" value="" step="0.1"><br>


    <label for="descricao">Descricao:</label><br>
    <input type="text" id="descricao" name="descricao" value=""><br>


    <label for="valor">Valor:</label><br>
    <input type="number" id="valor" name="valor" value="" step="0.01"><br><br>

    <input type="file" name="imagem 1" multiple/><br>

    <input type="submit" value="Submit" ><br>


</form>
</body>
</html>
