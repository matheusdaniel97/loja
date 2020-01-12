<%@ page import="java.util.List, com.matheus.lojawebc.modelo.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista empresas</title>
</head>
<body>

<a href="entrada?acao=Logout">Logout</a>

<br>
<br>
<br>

Usuario logado: ${usuarioLogado.login}

<br>
<br>
<br>

Lista de empresas: <br />
        <ul>
            <c:forEach items="${empresas}" var="empresa">
                <li>
                ${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
                <a href="/loja/entrada?acao=MostraEmpresa&id=${empresa.id}">editar</a>
                <a href="/loja/entrada?acao=RemoveEmpresa&id=${empresa.id}">remove</a>
                </li>
            </c:forEach>
        </ul>
        <br>
        <br>
        <a href="/loja/entrada?acao=FormCadastrarEmpresa">Cadastrar empresa</a>

</body>
</html>