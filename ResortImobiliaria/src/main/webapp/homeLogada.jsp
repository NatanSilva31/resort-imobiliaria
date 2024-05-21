<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <link href="./vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    
    <link rel="stylesheet" href="./pages/styles/styles.css">
    <style>
        .navbar{
            background-image: url('./Imagens/praia.jpg');
            background-size: cover;
            background-position: top;
            height: 90vh;
            display: block;
            justify-content: center;
            align-items: center;
            position: relative;
        }
         h1 {
                    text-align: center;
                }

         .user-icon {
          width: 21px; /* Ajuste o tamanho conforme necessário */
          height: auto; /* Mantém a proporção da imagem */
          display: block;
          justify-content: center;
          align-items: center;
          position: relative
                        }
    </style>
    <meta charset="UTF-8">
    <title>Cadastro</title>
</head>
<body>
<br>
<h1>Grandes Oportunidades</h1>
<center><li class="nav-item">
    <a class="nav-link special-link" href="/painel-imovel">Dashboard Imoveis</a>
</li></center>

<br>
<div class="row justify-content-center">
    <c:forEach var="imovel" items="${imoveis}" varStatus="loop">
        <div class="col-md-3 mb-4">
            <div class="card" style="width: 25rem;">
                <div class="card-body text-center">
                    <img src="/img/${imovel.imagens}" class="card-img-top" alt="...">
                    <h5 class="card-title">${imovel.tituloImovel}</h5>
                    <p class="card-text">R$ ${imovel.valorNoite}</p>
                    <a href="/infoImovel?id=${imovel.idCadastroImovel}" class="btn btn-primary" style="background-color: #494cf7; height: 3rem;">Detalhes do anuncio</a>
                </div>
            </div>
        </div>
        <c:if test="${loop.index % 4 == 3 || loop.last}">
            <div class="row justify-content-center"> <!-- Abre uma nova linha centralizada -->
        </c:if>
    </c:forEach>
</div>
<script src="webjars/bootstrap/5.3.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>
