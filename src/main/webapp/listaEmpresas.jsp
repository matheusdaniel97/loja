<%@ page import="java.util.List, com.matheus.lojawebc.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista empresas</title>
</head>
<body>

Lista de empresas: <br />
        <ul>
            <c:forEach items="${empresas}" var="empresa">
                <li>
                ${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
                <a href="/loja/mostraEmpresas?id=${empresa.id}">editar</a>
                <a href="/loja/removeEmpresa?id=${empresa.id}">remove</a>
                </li>
            </c:forEach>
        </ul>

</body>
</html>