<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>

    <form action="/loja/entrada" method="post">

        Login: <input type="text" name="login" />
        Senha: <input type="password" name="senha" />
        <input type="hidden" name="acao" value="Login"/>
        <input type="submit"/>
    </form>

<br>
<br>
<a href="/loja/entrada?acao=FormCadastrarUsuario">Cadastre-se</a>
<br>
<br>
<br>
-Se preferir utilize os dados abaixo:
<br>
-Login: Matheus
<br>
-Senha: Matheus123

</body>
</html>