<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>AJAX (dynamic table)</title>
    <script src="js/ListaCarrosAJAX.js"></script>
</head>
<body>
<br />
<jsp:useBean id='bean' class='br.ufscar.dsw1.katchau.bean.BuscaPorModeloBean' />

<form name='form'>
    <div align="center">
        <p>Lista de Carros</p>
        <label for="carro">Modelo</label> <input id="carro" name="carro"
                                                 onkeyUp="getCarros()">
        <div id="carros">

            <p>Quantidade: ${fn:length(bean.carros)}</p>
            <table border="1" style="width: 400px; border: 1px solid black">

                <tr>
                    <th style="width: 10%; text-align: center"></th>
                    <th style="width: 70%;">Modelo</th>
                    <th style="width: 20%; text-align: center">Ano</th>
                </tr>
                <c:forEach var="carro" items="${bean.carros}">
                    <tr>
                        <td style="text-align: center">
                        </td>

                        <td style="text-align: center">${carro.modelo}</td>
                        <td>${carro.ano}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</form>
<br />
</body>
</html>