<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

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

        <td>
            <c:out value="${usuario.codigo}"/>
        </td>
        <td><c:out value="${usuario.email}"/></td>
        <td><c:out value="${usuario.senha}"/></td>
        <td><c:out value="${usuario.papel}"/></td>
        <td><c:out value="${usuario.nome}"/></td>
<%--        <td><form action='./edit/?object=usuario&id=${loop.index}'><input type='submit' value="editar" /></form></td>--%>
<%--        <td><a href="./edit/?object=usuario&codigo=${usuario.codigo}&email=${usuario.email}&senha=${usuario.senha}&papel=${usuario.papel}&nome=${usuario.nome}">aaaa</a>--%>
        <td>
            <form action="./logado/adm/formUsuario.jsp" method="post">
                <input type="hidden" name="codigo" value="${usuario.codigo}">
                <input type="hidden" name="nome" value="${usuario.nome}">
                <input type="hidden" name="email" value="${usuario.email}">
                <input type="hidden" name="papel" value="${usuario.papel}">
                <input type="submit" name="submit" value="editar">

            </form>
        </td>



        </td>
            </tr>
    </c:forEach>

</table>




<h1>Lista de Clientes</h1><br>
<%--listaClientes--%>
<table border="1">
    <tr>

    <tr>
        <td>cpf</td>
        <td>telefone</td>
        <td>sexo</td>
        <td>nacimento</td>
    </tr>
    <c:forEach var="cliente" items="${listaClientes}">

        <td>
            <c:out value="${cliente.cpf}"/>
        </td>
        <td><c:out value="${cliente.telefone}"/></td>
        <td><c:out value="${cliente.sexo}"/></td>
        <td><c:out value="${cliente.nascimento}"/></td>


        </tr>
    </c:forEach>

</table>

<h1>Lista de Lojas</h1><br>
<%--listaLojas--%>
<table border="1">
    <tr>

    <tr>
        <td>cnpj</td>
        <td>descricao</td>
    </tr>
    <c:forEach var="loja" items="${listaLojas}">

        <td>
            <c:out value="${loja.cnpj}"/>
        </td>
        <td><c:out value="${loja.descricao}"/></td>

        </tr>
    </c:forEach>

</table>

<h1>Lista de Carros</h1>
<table border="1">
    <tr>

    <tr>
        <td>id</td>
        <td>cnpj</td>
        <td>placa</td>
        <td>modelo</td>
        <td>chassi</td>
        <td>descricao</td>
        <td>ano</td>
        <td>km</td>
        <td>valor</td>
    </tr>
    <c:forEach var="carro" items="${listaCarros}">

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
        <td>status</td>
        <td>data</td>
        <td>valor</td>
        <td>cpf</td>
        <td>cnpj</td>
        <td>carro_id</td>
        <td>condPag</td>
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

        </tr>
    </c:forEach>

</table>
</body>
</html>
