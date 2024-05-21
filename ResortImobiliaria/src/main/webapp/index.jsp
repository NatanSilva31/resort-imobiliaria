<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <title>Cadastro</title>
    <link rel="stylesheet" href="./Styles/Cadastro/cadastro.css">
</head>
<body>



<div class="containerCadastro">



        <h2>Cadastro Usuario</h2>


        <form action= "/cadastrouser" method= "post">



            <label>Nome</label>
            <input type="Text" name="nomeCompleto-cadastro" id="nomeCompleto-cadastro">

            <br>

            <label>E-mail</label>
            <input type="Text" name="email-cadastro" id="email-cadastro">


            <br>
            <label>Cpf</label>
            <input type="Text" name="cpf-cadastro" id="cpf-cadastro">

            <br>
            <label>Telefone</label>
            <input type="Text" name="telefone-cadastro" id="telefone-cadastro">
            <br>
            <label>Senha</label>
            <input type="password" name="senha-cadastro" id="senha-cadastro">

            <br>

            <label>Repetir Senha</label>
            <input type="password" name="repetirSenha-cadastro" id="repetirSenha-cadastro">


            <button type="submit">Register</button>




            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
        </form>
    </div>
</body>
</html>