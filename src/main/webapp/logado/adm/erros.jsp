<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Title</title>
</head>
<c:if test="${requestScope.erro != 0}">
<h1>Erro ${requestScope.erro}</h1>
</c:if>
<br>
<c:choose>

    <c:when test = "${requestScope.erro == 0}">
        <h1>A operação foi bem sucedida.</h1>
        <%--<h1>La operacio sukcesis. </h1>--%>
    </c:when>

    <c:when test = "${requestScope.erro == 1}">
        A operação não foi bem sucedida.
        <%--La operacio ne sukcesis. --%>
    </c:when>
    <c:when test = "${requestScope.erro == 2}">
        Você já tem uma proposta aberta para esse veiculo.
        <%--Vi jam havas malferman proponon por ĉi tiu veturilo. --%>
    </c:when>
    <c:when test = "${requestScope.erro == 3}">
        Houve um erro na conexão com o banco de dados.
        <%--Estis eraro konektante al la datumbazo. --%>
    </c:when>
    <c:when test = "${requestScope.erro == 4}">
        Sua Sessão como Cliente está inválida.
        <%--Via Klienta Sesio ne validas. --%>
    </c:when>
    <c:when test = "${requestScope.erro == 5}">
        Sua Sessão como Administrador está inválida.
        <%--Via Administrada Sesio ne validas. --%>
    </c:when>
    <c:when test = "${requestScope.erro == 6}">
        Um objeto com esse codigo já estava inserido no banco de dados.
        <%--Objekto kun ĉi tiu kodo jam estis enmetita en la datumbazon. --%>
    </c:when>
    <c:when test = "${requestScope.erro == 7}">
        O objeto com esse codigo não existe.
        <%--La objekto kun ĉi tiu kodo ne ekzistas. --%>
    </c:when>
    <c:when test = "${requestScope.erro == 8}">
        Você não preencheu todos os campos do formulário.
        <%--Vi ne plenigis ĉiujn kampojn en la formularo. --%>
    </c:when>
    <c:when test = "${requestScope.erro == 9}">
        Você tentou inserir um objeto, entretanto, ele entrou em conflito com um objeto já inserido.

        <br>
        Tente usar outro email ou algo assim.
        <%--Vi provis enmeti objekton, tamen ĝi konfliktis kun jam enmetita objekto.<br>
        Provu uzi alian retpoŝton aŭ ion similan. --%>
    </c:when>

    <c:when test = "${requestScope.erro == 400}">
        Requisição mal formada.<br>
        Você preencheu todos os campos?

        <br>Por favor contate um adm.
        <%--Malbone formita peto. <br>
         Ĉu vi plenigis ĉiujn kampojn?

         <br> Bonvolu kontakti adm. --%>
    </c:when>

    <c:otherwise>
    </c:otherwise>
</c:choose>
<br>
<br>
<br>
<button class="btn" onclick="window.location.href='${pageContext.request.contextPath}'">Voltar</button>

</body>
</html>
