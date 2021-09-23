<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>PAINEL DO CLIENTE</title>
    <meta charset="UTF-8">
</head>
<body>
<h2>Propostas abertas:</h2>
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
<h2>Propostas fechadas:</h2>
<table border="1" style="width: 400px; border: 1px solid black">
    <tr>
        <th>ID</th>
        <th>Data da proposta</th>
        <th>Valor</th>
        <th>Condição de Pagamento</th>
        <th>Status</th>
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
</body>
</html>
