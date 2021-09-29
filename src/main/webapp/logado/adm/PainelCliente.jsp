<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%--Formulario referente ao painel de cliente.--%>

<html>
<head>
    <title>PAINEL DO CLIENTE</title>
    <meta charset="UTF-8">
</head>
<body>
<h2><fmt:message key="propFechadas"/></h2>
<table border="1" style="width: 400px; border: 1px solid black">
    <tr>
        <th>ID</th>
        <th>Data da proposta</th>
        <th>Valor</th>
        <th>Condição de Pagamento</th>
        <th>Status</th>
    </tr>
<c:forEach var="proposta" items="${ListaPropostas.stream().filter(p -> p.status == 0).toList()}">

        <tr>
            <td>
                <c:out value="${proposta.id}"/>
            </td>
            <td><c:out value="${proposta.data}"/></td>
            <td><c:out value="${proposta.val}"/></td>
            <td><c:out value="${proposta.condPag}"/></td>
            <td><c:out value="ABERTO"/></td>
        </tr>

</c:forEach>
</table>
<h2><fmt:message key="propFechada"/></h2>
<table border="1" style="width: 400px; border: 1px solid black">
    <tr>
        <th>ID</th>
        <th><fmt:message key="dataProp"/></th>
        <th><fmt:message key="valor"/></th>
        <th><fmt:message key="condPag"/></th>
        <th><fmt:message key="status"/></th>
    </tr>
<c:forEach var="proposta" items="${ListaPropostas.stream().filter(p -> p.status != 0).toList()}">

        <tr>
            <td>
                <c:out value="${proposta.id}"/>
            </td>
            <td><c:out value="${proposta.data}"/></td>
            <td><c:out value="${proposta.val}"/></td>
            <td><c:out value="${proposta.condPag}"/></td>
            <td><c:out value="${proposta.status == 1 ? 'ACEITO' :  'NÃO ACEITO'  }"/></td>

        </tr>

</c:forEach>
</table>
</fmt:bundle>
</body>
</html>
