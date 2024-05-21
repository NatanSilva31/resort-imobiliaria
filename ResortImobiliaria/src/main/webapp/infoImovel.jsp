<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="./vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="./Styles/infoImovel/infoImovel.css">
    <title>Informações do Imóvel</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <style>
        body {
            background-color: white;
        }
        .container-table {
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 10px;
            margin-top: 20px;
            background-color: white;
        }
        .table-informacoes, .table-contato {
            margin-bottom: 20px;
        }
        .table-informacoes th, .table-contato th {
            background-color: #f2f2f2;
            text-align: center;
        }
        .table-informacoes td, .table-contato td {
            text-align: center;
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
    <center><h1>${imovel.tituloImovel}</h1></center>

    <div class="container-table">
        <div class="containerIMG-table">
            <div class="containerIMG">
                <img src="/img/${imovel.imagens}" class="img-fluid" alt="Imagem do Imóvel" style="width: 100%; height: auto; object-fit: cover; border-radius: 10px; margin: 2rem;">
            </div>
        </div>
        
        <div class="table-responsive">
            <table class="table table-informacoes table-bordered">
                <thead>
                    <tr>
                        <th>Imóvel</th>
                        <th>Endereço</th>
                        <th>Quartos</th>
                        <th>Banheiros</th>
                        <th>Vagas</th>
                        <th>Valor</th>
                        <th>Observações</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="imovel" items="${imovel}">
                        <tr>
                            <td>${imovel.tituloImovel}</td>
                            <td>${imovel.endereco}</td>
                            <td>${imovel.numQuartos}</td>
                            <td>${imovel.numBanheiro}</td>
                            <td>${imovel.numVagas}</td>
                            <td>R$ ${imovel.valorNoite}</td>
                            <td>${imovel.obs}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <div class="table-responsive">
            <table class="table table-contato table-bordered">
                <thead>
                    <tr>
                        <th>Email de Contato</th>
                        <th>Telefone de Contato</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="imovel" items="${imovel}">
                        <tr>
                            <td><a href="mailto:${imovel.email}">${imovel.email}</a></td>
                            <td><a href="tel:${imovel.telefone}">${imovel.telefone}</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <div class="whatsapp-btn">
            <a href="https://wa.me/55${imovel.telefone}" target="_blank">
                <i class="fab fa-whatsapp"></i> Contatar via WhatsApp
            </a>
        </div>
    </div>

    <script src="webjars/bootstrap/5.3.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>
