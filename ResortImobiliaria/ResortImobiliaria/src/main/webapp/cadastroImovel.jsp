<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="./Styles/Cadastro_Imovel/cadastroImovel.css">
    <title>Cadastro Imovel</title>
</head>

<body>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }

        .container {
            background-color: #ffffff;
            padding: 200px;
            margin: 50px auto;
            border-radius: 10px;
            max-width: 800px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        .form-group {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
        }

        .form-column {
            flex: 1;
            min-width: 45%;
            padding: 10px;
            margin: 10px;
        }

        label {
            display: block;
            margin-bottom: 5px;
        }

        input[type="text"],
        input[type="number"],
        input[type="file"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        button {
            display: block;
            width: 100%;
            padding: 15px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }

        button:hover {
            background-color: #0056b3;
        }
    </style>
    <div class="container">
        <h2>Cadastro de imoveis</h2>
        <form action="cadastroImovel" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <div class="form-column">
                    <label for="titulo-imovel">Titulo Imovel:</label>
                    <input type="text" name="titulo-imovel" id="titulo-imovel" value="${param.name}">

                    <label for="endereco">Endereco:</label>
                    <input type="text" name="endereco" id="endereco" value="${param.endereco}">

                    <label for="numero-quartos">Numero de Quartos:</label>
                    <input type="text" name="numero-quartos" id="numero-quartos" value="${param.numquartos}">

                    <label for="numero-banheiros">Numero de Banheiros:</label>
                    <input type="text" name="numero-banheiros" id="numero-banheiros" value="${param.numbanheiro}">

                    <label for="numero-vagas">Numero de Vagas:</label>
                    <input type="text" name="numero-vagas" id="numero-vagas" value="${param.numvagas}">
                </div>
                <div class="form-column">
                    <label for="valor">Valor do imovel: R$</label>
                    <input type="number" name="valor" id="valor" value="${param.valornoite}">

                    <label for="obs">Observacoes:</label>
                    <input type="text" name="obs" id="obs" value="${param.obs}">

                    <label for="email-contato">Email para contato:</label>
                    <input type="text" name="email-contato" id="email-contato" value="${param.Email}">

                    <label for="telefone-contato">Telefone para contato:</label>
                    <input type="text" name="telefone-contato" id="telefone-contato" value="${param.telefone}">

                    <label for="imagens">Imagem</label>
                    <input type="file" name="imagens" id="imagens" value="${param.imagens}">
                </div>
            </div>
            <button type="submit">Cadastrar</button>
            <input type="hidden" id="idCadastroImovel" name="idCadastroImovel" value="${param.idCadastroImovel}">
        </form>
    </div>
</body>

</html>