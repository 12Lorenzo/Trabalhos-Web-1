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
                    <th style="width: 70%;">Modelo</th>
                    <th style="width: 70%;">Placa</th>
                    <th style="width: 70%;">Chassi</th>
                    <th style="width: 70%;">Descricao</th>
                    <th style="width: 20%; text-align: center">Ano</th>
                    <th style="width: 70%;">Km</th>
                    <th style="width: 70%;">Valor</th>
                </tr>
                <c:forEach var="carro" items="${bean.carros}">
                    <tr>

                        <td style="text-align: center">${carro.modelo}</td>
                        <td style="text-align: center">${carro.placa}</td>
                        <td style="text-align: center">${carro.chassi}</td>
                        <td style="text-align: center">${carro.descricao}</td>
                        <td style="text-align: center">${carro.ano}</td>
                        <td style="text-align: center">${carro.km}</td>
                        <td style="text-align: center">${carro.valor}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</form>
<br />
</body>
</html>