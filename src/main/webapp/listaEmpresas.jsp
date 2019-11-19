<% page import="java.util.List, com.matheus.lojawebc.servlet.Empresa"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

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