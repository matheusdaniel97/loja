<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edita empresa</title>
</head>
<body>

    <form action="/loja/alteraEmpresa" method="post">

        Nome: <input type="text" name="nome" value="${empresa.nome}"/>
        Data de abertura: <input type="text" name="data" value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>">
        <input type="hidden" name="id" value="${empresa.id}" />
        <input type="submit" />
    </form>

</body>
</html>