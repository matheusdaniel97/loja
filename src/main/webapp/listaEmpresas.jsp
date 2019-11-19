<%@ page import="java.util.List, com.matheus.lojawebc.Empresa" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

    Lista de empresas: <br />
        <ul>
        <%
            List<Empresa> lista = (List<Empresa>)request.getAttribute("empresas");
            for (Empresa empresa : lista) {
        %>
            <li><%= empresa.getNome() %></li>
        <%
            }
        %>
        </ul>

</body>
</html>