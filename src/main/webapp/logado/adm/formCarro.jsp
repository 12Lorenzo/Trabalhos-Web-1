<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="" method="${requestScope.formMethod}" enctype="multipart/form-data">
    <label for="cnpj">CNPJ:</label><br>
    <input type="text" id="cnpj" name="cnpj" value=""><br>

    <label for="placa">Placa:</label><br>
    <input type="text" id="placa" name="placa" value=""><br>


    <label for="modelo">Modelo:</label><br>
    <input type="text" id="modelo" name="modelp" value=""><br>


    <label for="chassi">Chassi:</label><br>
    <input type="text" id="chassi" name="chassi" value=""><br>


    <label for="ano">Ano:</label><br>
    <input type="int" id="ano" name="ano" value=""><br>


    <label for="km">Km:</label><br>
    <input type="float" id="km" name="km" value=""><br>


    <label for="descricao">Descricao:</label><br>
    <input type="text" id="descricao" name="descricao" value=""><br>


    <label for="valor">Valor:</label><br>
    <input type="float" id="valor" name="valor" value=""><br>



    <input type="file" name="imagem 1" />
    <input type="file" name="imagem 2" />
    <input type="file" name="imagem 3" />
    <input type="file" name="imagem 4" />
    <input type="file" name="imagem 5" />
    <input type="file" name="imagem 6" />
    <input type="file" name="imagem 7" />
    <input type="file" name="imagem 8" />
    <input type="file" name="imagem 9" />
    <input type="file" name="imagem 10" />

    <input type="submit" value="Submit"><br>


</form>
</body>
</html>
