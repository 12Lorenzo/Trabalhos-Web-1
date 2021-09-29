<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%--Formulario referente a inserção de um carro--%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<fmt:bundle basename="messages">
<form action="${pageContext.request.contextPath}/carros/" method="post" enctype= "multipart/form-data">

    <label for="placa"><fmt:message key="placa"/></label><br>
    <input type="text" required="required" id="placa" name="placa" value=""><br>


    <label for="modelo"><fmt:message key="modelo"/></label><br>
    <input type="text" required="required" id="modelo" name="modelo" value=""><br>


    <label for="chassi"><fmt:message key="chassi"/></label><br>
    <input type="text" required="required" id="chassi" name="chassi" value=""><br>


    <label for="ano"><fmt:message key="ano"/></label><br>
    <input type="number" required="required" id="ano" name="ano" value=""><br>


    <label for="km"><fmt:message key="km"/></label><br>
    <input type="number" required="required" id="km" name="km" value="" step="0.1"><br>


    <label for="descricao"><fmt:message key="descricao"/></label><br>
    <input type="text" required="required" id="descricao" name="descricao" value=""><br>


    <label for="valor"><fmt:message key="valor"/></label><br>
    <input type="number" required="required" id="valor" name="valor" value="" step="0.01"><br><br>

    <input class="arquivos" type="file" required="required" name="imagem 1" multiple/><br>

    <input type="submit" value="Submit" ><br>


</form>
</fmt:bundle>
</body>
</html>
