<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="./vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="./Styles/infoImovel/infoImovel.css">
    <title>Informações do Imóvel</title>
    <link rel="shortcut icon" href="./imagens/favicon.png" type="image/x-icon" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <style>
        body {
            background-color: white;
        }
        .container-table {
            padding: 20px;
            border-radius: 10px;
            margin-top: 20px;
            background-color: white;
            max-width: 800px;
            margin-left: auto;
            margin-right: auto;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }
        .containerIMG {
            text-align: center;
            margin-bottom: 20px;
        }
        .containerIMG img {
            max-width: 100%;
            height: auto;
            object-fit: cover;
            border-radius: 10px;
        }
        .info-section {
            margin-bottom: 20px;
            text-align: left;
        }
        .info-section h2 {
            background-color: #f2f2f2;
            padding: 10px;
            border-radius: 5px;
            text-align: center;
        }
        .info-section p {
            padding: 10px;
        }
        .info-section p:last-child {
            border-bottom: none;
        }
        .whatsapp-btn {
            display: flex;
            align-items: center;
            justify-content: center;
            margin-top: 20px;
        }
        .whatsapp-btn a {
            display: inline-block;
            padding: 10px 20px;
            background-color: #25D366;
            color: white;
            border-radius: 5px;
            text-decoration: none;
        }
        .whatsapp-btn a i {
            margin-right: 10px;
        }
    </style>
</head>
<body>
    <header class="p-3 fixed-top">
        <div
            class="container d-flex flex-wrap align-items-center justify-content-center justify-content-md-between mb-1 ">
            <a href="javascript:void(0)"
                class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none"
                onclick="history.back()">
                <img src="../vendor/bootstrap/bootstrap-icons/arrow-bar-left.svg" alt="Back" width="30" height="50"
                    title="Back">
            </a>
        </div>
    </header>
    <div class="container-table">
        <center><h1>${imovel.tituloImovel}</h1></center>

        <div class="containerIMG">
            <img src="/img/${imovel.imagens}" class="img-fluid" alt="Imagem do Imóvel">
        </div>

        <div class="info-section">
            <h2>Detalhes do Imovel</h2>
            <p><strong>Imovel:</strong> ${imovel.tituloImovel}</p>
            <p><strong>Endereco:</strong> ${imovel.endereco}</p>
            <p><strong>Quartos:</strong> ${imovel.numQuartos}</p>
            <p><strong>Banheiros:</strong> ${imovel.numBanheiro}</p>
            <p><strong>Vagas:</strong> ${imovel.numVagas}</p>
            <p><strong>Valor:</strong> R$ ${imovel.valorNoite}</p>
            <p><strong>Observacoes:</strong> ${imovel.obs}</p>
        </div>

        <div class="info-section">
            <h2>Contato</h2>
            <p><strong>Email:</strong> <a href="mailto:${imovel.email}">${imovel.email}</a></p>
            <p><strong>Telefone:</strong> <a href="tel:${imovel.telefone}">${imovel.telefone}</a></p>
        </div>

        <div class="whatsapp-btn">
            <a href="https://wa.me/55${imovel.telefone}" target="_blank">
                <i class="fab fa-whatsapp"></i> Contatar via WhatsApp
            </a>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-BO6GGIgiMmxGZWgpLsc7u6BrtoILJjKft6LP0jFISZpVbriH1EqYjFMoXr37qz4p" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgEp2S68PldQ1vF0qLTe6mTFo6T76w43ISxOUyn+1kT5EnHgU77" crossorigin="anonymous"></script>
</body>
</html>
