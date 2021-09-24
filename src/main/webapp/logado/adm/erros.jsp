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
    </c:when>

    <c:when test = "${requestScope.erro == 1}">
        A operação não foi bem sucedida.
    </c:when>
    <c:when test = "${requestScope.erro == 2}">
        Você já tem uma proposta aberta para esse veiculo.
    </c:when>
    <c:when test = "${requestScope.erro == 3}">
        Houve um erro na conexão com o banco de dados.
    </c:when>
    <c:when test = "${requestScope.erro == 4}">
        Sua Sessão como Cliente está inválida.
    </c:when>
    <c:when test = "${requestScope.erro == 5}">
        Sua Sessão como Adm está inválida.
    </c:when>
    <c:when test = "${requestScope.erro == 6}">
        Um objeto com esse codigo já estava inserido no banco de dados.
    </c:when>
    <c:when test = "${requestScope.erro == 7}">
        O objeto com esse codigo não existe.
    </c:when>

    <c:when test = "${requestScope.erro == 400}">
        Requisição mal formada, por favor contate um adm.
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
