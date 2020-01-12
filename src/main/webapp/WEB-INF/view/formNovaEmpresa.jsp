<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Nova empresa</title>
</head>
<body>

    <form action="/loja/entrada" method="post">

        Nome: <input type="text" name="nome" />
        Data de abertura: <input type="text" name="data" />
        <input type="hidden" name="acao" value="CadastrarEmpresa"/>
        <input type="submit"/>
    </form>

</body>
</html>