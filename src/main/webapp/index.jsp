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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
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
    <c:if test="${sessionScope.user.papel == 3}">
        <a href="${pageContext.request.contextPath.concat('/painelCliente') }">Meu Painel</a>
    </c:if>
</c:if>
<input type='hidden' name='${boo}' value='${boo}' id='propor'/>
<form name='form'>

    <div align="center">
        <p><fmt:message key="lista_de_carros"/></p>
        <label for="carro"><fmt:message key="modelo"/></label> <input id="carro" name="carro"
                                                 onkeyUp="getCarros('${pageContext.request.contextPath}')">
        <div id="carros">

            <p>Quantidade: <span id="qtd">${fn:length(bean.carros)}</span></p>
            <table id="table table-striped" border="1" style="width: 400px; border: 1px solid black">
                <thead>

                <tr>
                    <th style="width: 70%;text-align: center"><fmt:message key="imagem"/></th>
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
                    <tr><td>

                        <c:if test="${carro.getImages(pageContext.servletContext.getRealPath('upload')).size() > 0}">


                                <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel" style="width: 300px">
                                    <div class="carousel-inner">
                                        <c:forEach var="img" items="${carro.getImages(pageContext.servletContext.getRealPath('upload'))}" varStatus="loopimg">
                                            <div class="carousel-item ${loopimg.index == 0? 'active':''}">
                                                <img src="${img}" class="d-block w-100" height="200px" alt="...">
                                            </div>
                                        </c:forEach>
                                    </div>
                                    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
                                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                        <span class="visually-hidden">Previous</span>
                                    </button>
                                    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
                                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                        <span class="visually-hidden">Next</span>
                                    </button>
                                </div>


                        </c:if></td>
                        <td style="text-align: center">${carro.modelo}</td>
                        <td style="text-align: center">${carro.placa}</td>
                        <td style="text-align: center">${carro.chassi}</td>
                        <td style="text-align: center">${carro.descricao}</td>
                        <td style="text-align: center">${carro.ano}</td>
                        <td style="text-align: center">${carro.km}</td>
                        <td style="text-align: center">${carro.valor}</td>
                        <c:if test = "${boo}">
                            <td style="text-align: center"><a href="${pageContext.request.contextPath.concat('/proposta/').concat(carro.id.toString())}">+</a></td>
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