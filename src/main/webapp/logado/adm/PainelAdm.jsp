<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<fmt:bundle basename="messages">

<h1>Lista de Usuários</h1>

<table border="1">
    <tr>

    <tr>
        <td>codigo</td>
        <td>email</td>
        <td>senha</td>
        <td>papel</td>
        <td>nome</td>
    </tr>

    <c:forEach var="usuario" items="${listaUsuarios}" varStatus="loop">
    <tr>
        <td>
            <c:out value="${usuario.codigo}"/>
        </td>
        <td><c:out value="${usuario.email}"/></td>
        <td><c:out value="${usuario.senha}"/></td>
        <td><c:out value="${usuario.papel}"/></td>
        <td><c:out value="${usuario.nome}"/></td>

            </tr>
    </c:forEach>

</table>


<h1>Lista de Clientes</h1><br>
<%--listaClientes--%>

<td><a href="${pageContext.request.contextPath}/cliente/post/*">Cadastrar cliente</a></td>
<table border="1">
    <tr>

    <tr>
        <td>cpf</td>
        <td>telefone</td>
        <td>sexo</td>
        <td>nacimento</td>
    </tr>
    <c:forEach var="cliente" items="${listaClientes}">
        <tr>
        <td>
            <c:out value="${cliente.cpf}"/>
        </td>
        <td><c:out value="${cliente.telefone}"/></td>
        <td><c:out value="${cliente.sexo}"/></td>
        <td><c:out value="${cliente.nascimento}"/></td>
        <td><a href="${pageContext.request.contextPath}/cliente/put/${cliente.cpf}">Editar cliente</a></td>
        <td><a href="${pageContext.request.contextPath}/cliente/delete/${cliente.cpf}">Deletar cliente</a></td>
        </tr>
    </c:forEach>

</table>

<h1>Lista de Lojas</h1><br>
<%--listaLojas--%>
<table border="1">
    <tr>

    <tr>
        <td>cnpj</td>
        <td><fmt:message key="descricao"/> </td>
    </tr>
    <c:forEach var="loja" items="${listaLojas}">

        <td>
            <c:out value="${loja.cnpj}"/>
        </td>
        <td><c:out value="${loja.descricao}"/></td>

        </tr>
    </c:forEach>

</table>

<h1><fmt:message key="lista_de_carros"/></h1>
<br>

<table border="1">
    <tr>

    <tr>
        <td>id</td>
        <td><fmt:message key="cnpj_loja"/></td>
        <td><fmt:message key="placa"/></td>
        <td><fmt:message key="modelo"/></td>
        <td><fmt:message key="chassi"/></td>
        <td><fmt:message key="descricao"/></td>
        <td><fmt:message key="ano"/></td>
        <td><fmt:message key="km"/></td>
        <td><fmt:message key="valor"/></td>
    </tr>
    <c:forEach var="carro" items="${listaCarros}">
        <tr>
        <td>
            <c:out value="${carro.id}"/>
        </td>
        <td><c:out value="${carro.cnpj}"/></td>
        <td><c:out value="${carro.placa}"/></td>
        <td><c:out value="${carro.modelo}"/></td>
        <td><c:out value="${carro.chassi}"/></td>
        <td><c:out value="${carro.descricao}"/></td>
        <td><c:out value="${carro.ano}"/></td>
        <td><c:out value="${carro.km}"/></td>
        <td><c:out value="${carro.valor}"/></td>

        </tr>
    </c:forEach>

</table>
<h1>Lista de Propostas</h1><br>
<%--listaPropostas--%>
<table border="1">
    <tr>

    <tr>
        <td>id</td>
        <td><fmt:message key="status"/></td>
        <td><fmt:message key="data"/></td>
        <td><fmt:message key="valor"/></td>
        <td><fmt:message key="cpf"/></td>
        <td><fmt:message key="cnpj"/></td>
        <td><fmt:message key="carro_id"/></td>
        <td><fmt:message key="condPag"/></td>
    </tr>

    <c:forEach var="proposta" items="${listaPropostas}">

        <td>
            <c:out value="${proposta.id}"/>
        </td>
        <td><c:out value="${proposta.status}"/></td>
        <td><c:out value="${proposta.data}"/></td>
        <td><c:out value="${proposta.val}"/></td>
        <td><c:out value="${proposta.cpf}"/></td>
        <td><c:out value="${proposta.cnpj}"/></td>
        <td><c:out value="${proposta.carro_id}"/></td>
        <td><c:out value="${proposta.condPag}"/></td>

        </td>

        </tr>
    </c:forEach>

</table>
</fmt:bundle>
</body>
</html>