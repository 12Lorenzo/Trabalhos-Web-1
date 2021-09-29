<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%--Responsavel por guardar os erros.--%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${requestScope.erro != 0}">
<h1>Erro ${requestScope.erro}</h1>
</c:if>
<br>
    <h1>
<c:choose>

    <c:when test = "${requestScope.erro == 0}">
        <fmt:message key="erro0" />
    </c:when>

    <c:when test = "${requestScope.erro == 1}">
        <fmt:message key="erro1" />
    </c:when>
    <c:when test = "${requestScope.erro == 2}">
        <fmt:message key="erro2" />
    </c:when>
    <c:when test = "${requestScope.erro == 3}">
        <fmt:message key="erro3"/>
    </c:when>
    <c:when test = "${requestScope.erro == 4}">
        <fmt:message key="erro4"/>
    </c:when>
    <c:when test = "${requestScope.erro == 5}">
        <fmt:message key="erro5"/>
    </c:when>
    <c:when test = "${requestScope.erro == 6}">
        <fmt:message key="erro6"/>
    </c:when>
    <c:when test = "${requestScope.erro == 7}">
        <fmt:message key="erro7" />
    </c:when>
    <c:when test = "${requestScope.erro == 8}">
        <fmt:message key="erro8" />
    </c:when>
    <c:when test = "${requestScope.erro == 9}">
        <fmt:message key="erro9" />
    </c:when>
    <c:when test = "${requestScope.erro == 10}">
        <fmt:message key="erro10" />
    </c:when>

    <c:when test = "${requestScope.erro == 400}">
        <fmt:message key="erro400"/>
    </c:when>

    <c:otherwise>
    </c:otherwise>

</c:choose>
    </h1>
<br>
<br>
<br>
<button class="btn" onclick="window.location.href='${pageContext.request.contextPath}'"><fmt:message key="voltar"/> </button>
</fmt:bundle>
</body>
</html>
