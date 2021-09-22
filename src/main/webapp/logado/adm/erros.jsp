<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Title</title>
</head>
<h1>Erros</h1>
<c:choose>

    <c:when test = "${requestScope.erro == 0}">
        A operação foi bem sucedida.
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
    <c:when test = "${requestScope.erro == 404}">
        Requisição mal formada, por favor contate um adm.
    </c:when>

    <c:otherwise>
    </c:otherwise>
</c:choose>
<br>
<button class="btn" onclick="window.location.href='${pageContext.request.contextPath}'">Voltar</button>

</body>
</html>
