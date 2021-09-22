<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Katchau</title>
    <script src="${pageContext.request.contextPath.concat('/js/ListaCarrosAJAX.js')}"></script>
</head>
<body>
<fmt:bundle basename="messages">
<br />
<jsp:useBean id='bean' class='br.ufscar.dsw1.katchau.bean.BuscaPorModeloBean' />
<%--<%=request.getSession().getAttribute("message")%>--%>

<c:set var="boo" value="${sessionScope.user == null? false : sessionScope.user.papel == 3}"/>
<%--<c:out value = "${boo}"/>--%>

<c:if test="${sessionScope.user == null}">
    <a href="${pageContext.request.contextPath.concat('/Validator') }">Login</a>
</c:if>
<c:if test="${sessionScope.user != null}">
    <a href="${pageContext.request.contextPath.concat('/Validator/logout') }">Logout</a>
</c:if>
<input type='hidden' name='${boo}' value='${boo}' id='propor'/>
<form name='form'>

    <div align="center">
        <p><fmt:message key="lista_de_carros"/></p>
        <label for="carro"><fmt:message key="modelo"/></label> <input id="carro" name="carro"
                                                 onkeyUp="getCarros()">
        <div id="carros">

            <p>Quantidade: <span id="qtd">${fn:length(bean.carros)}</span></p>
            <table id="tabela" border="1" style="width: 400px; border: 1px solid black">
                <thead>

                <tr>
                    <th style="width: 70%;text-align: center"><fmt:message key="modelo"/></th>
                    <th style="width: 70%;text-align: center"><fmt:message key="placa"/></th>
                    <th style="width: 70%;text-align: center"><fmt:message key="chassi"/></th>
                    <th style="width: 70%;text-align: center"><fmt:message key="descricao"/></th>
                    <th style="width: 70%;text-align: center"><fmt:message key="ano"/></th>
                    <th style="width: 70%;text-align: center"><fmt:message key="km"/></th>
                    <th style="width: 70%;text-align: center"><fmt:message key="valor"/></th>

                    <c:if test = "${boo}">
                        <th style="width: 70%;"><fmt:message key="propor"/></th>
                    </c:if>
                </tr>
                </thead>
                <tbody id="tbody">
                <c:forEach var="carro" items="${bean.carros}">
                    <tr>

                        <td style="text-align: center">${carro.modelo}</td>
                        <td style="text-align: center">${carro.placa}</td>
                        <td style="text-align: center">${carro.chassi}</td>
                        <td style="text-align: center">${carro.descricao}</td>
                        <td style="text-align: center">${carro.ano}</td>
                        <td style="text-align: center">${carro.km}</td>
                        <td style="text-align: center">${carro.valor}</td>
                        <c:if test = "${boo}">
                            <td style="text-align: center"><a href=""><fmt:message key="fazer_proposta"/></a></td>
                        </c:if>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</form>
<br />
</fmt:bundle>
</body>
</html>