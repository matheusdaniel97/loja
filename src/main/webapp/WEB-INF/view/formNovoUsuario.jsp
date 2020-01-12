<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Novo usuario</title>
</head>
<body>

    <form action="/loja/entrada" method="post">

        Login: <input type="text" name="login" />
        Senha: <input type="password" name="senha" />
        <input type="hidden" name="acao" value="CadastrarUsuario"/>
        <input type="submit"/>
    </form>

</body>
</html>