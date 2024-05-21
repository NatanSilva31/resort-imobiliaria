<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <link href="./vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="./pages/styles/styles.css">
    <style>
        .navbar {
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
            margin-top: 5rem;
        }
        .popup {
            display: none;
            position: fixed;
            z-index: 9999;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            border-radius: 1rem;
            background-color: rgba(0,0,0,0.5);
        }
        .popup-content {
            background-color: #fefefe;
            margin: 20% auto;
            padding: 20px;
            border: 1px solid #888;
            width: 80%;
            max-width: 400px;
        }
        .close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }
        .close:hover,
        .close:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
        }
        /* Margin e distâncias para os elementos */
        .nav__menu {
            margin-top: 30px;
        }
        .nav__item {
            margin-right: 20px;
        }
        .botao1 {
            margin-right: 10px;
        }
        .botao2 {
            margin-left: 10px;
        }
        .row.justify-content-center {
            margin-top: 30px;
            margin-bottom: 30px;
        }
        .card {
            margin-bottom: 20px; /* Ajuste de margem entre os cards */
        }
        .header {
            margin-bottom: 20px; /* Ajuste de margem para o header */
        }
    </style>
    <meta charset="UTF-8">
    <title>Cadastro</title>
</head>
<body>
<header class="header" id="header">
    <nav class="nav container">
        <div class="container d-flex flex-wrap align-items-center justify-content-center justify-content-md-between mb-3">
            <a style="color: black;" href="/HomeNaoLogada" class="nav__logo">
                Resort Imobiliária <i class="bx bxs-home"></i>
            </a>
            <div class="nav__menu">
                <ul class="nav__list">
                    <li class="nav__item">
                        <a href="#value" class="nav__link">
                            <i class="bx bx-award"></i>
                            <span>Valores</span>
                        </a>
                    </li>
                    <li class="nav__item">
                        <a href="#contact" class="nav__link">
                            <i class="bx bx-phone"></i>
                            <span>Contato</span>
                        </a>
                    </li>
                    <li class="nav__item">
                        <a href="#subscribe" class="nav__link">
                            <i class="bx bx-phone"></i>
                            <span>Agendar Visita</span>
                        </a>
                    </li>
                    <li class="nav__item">
                        <a href="./pages/create-imovel.jsp" class="nav__link">
                            <i class="bx bx-phone"></i>
                            <span>Imóveis</span>
                        </a>
                    </li>
                    <li class="botao1 list-group-item nav-item">
                        <a href="../pages/login.html" class="btn btn-outline-secondary me-2 d-block text-decoration-none rounded-pill"
                           style="width: 90px; height: 40px;">Login</a>
                    </li>
                    <!-- Caso o usuário já tenha logado -->
                    <li class="botao2 list-group-item nav-item dropdown-custom visually-hidden">
                        <a href="#" class="d-block link-body-emphasis text-decoration-none" data-bs-toggle="dropdown"
                           aria-expanded="false">
                            <img src="assets/images/perfil/perfil.jpg" alt="mdo" width="50px" height="50px"
                                 class="rounded-circle">
                        </a>
                        <ul class="dropdown-menu  gap-1 p-2 rounded-3 mx-0 shadow w-220px">
                            <li>
                                <a class="dropdown-item rounded-2" href="pages/profile.html">
                                    <img id="AnunciarHeader" src="/vendor/bootstrap/bootstrap-icons/person.svg" alt="" width="20px" title="Perfil">
                                    &nbsp; Anunciar</a>
                            </li>
                            <li>
                                <a class="dropdown-item rounded-2" href="pages/profile.html">
                                    <img src="/vendor/bootstrap/bootstrap-icons/person.svg" alt="" width="20px" title="Perfil">
                                    &nbsp; Perfil</a>
                            </li>
                            <li>
                                <a class="dropdown-item rounded-2" href="./pages/Favoritos.html">
                                    <img src="/vendor/bootstrap/bootstrap-icons/heart.svg" alt="" title="Favoritos">
                                    &nbsp; Favoritos
                                </a>
                            </li>
                            <li>
                                <a class="dropdown-item rounded-2" href="#">
                                    <img src="/vendor/bootstrap/bootstrap-icons/gear.svg" alt="" title="Configuração">
                                    &nbsp; Configuração</a>
                            </li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li>
                                <a class="dropdown-item d-flex gap-2 align-items-center" id="logoutButton">
                                    <img src="/vendor/bootstrap/bootstrap-icons/box-arrow-left.svg" alt="" title="logout">
                                    &nbsp; logout
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>

<!-- Pop-up de aviso -->
<div id="popup" class="popup">
    <div class="popup-content">
        <span class="close" onclick="fecharPopup()">&times;</span>
        <p>Faça login para acessar esse conteudo.</p>
    </div>
</div>
<h1 style="padding-top: 3rem;">Imoveis disponiveis</h1>
<div class="row justify-content-center">
    <c:forEach var="imovel" items="${imoveis}" varStatus="loop">
        <div class="col-md-3 mb-4">
            <div class="card" style="width: 25rem;">
                <div class="card-body text-center">
                    <img src="/img/${imovel.imagens}" class="card-img-top" alt="...">
                    <h5 class="card-title">${imovel.tituloImovel}</h5>
                    <p class="card-text">R$ ${imovel.valorNoite}</p>
                    <!-- Botão com a cor personalizada -->
                    <button onclick="mostrarPopup()" class="btn btn-primary" style="background-color: #494cf7; color: rgb(0, 0, 0); height: 3rem;">Detalhes do anuncio</button>
                </div>
            </div>
        </div>
        <c:if test="${loop.index % 4 == 3 || loop.last}">
            </div> <!-- fecha a linha -->
            <div class="row justify-content-center"> <!-- abre uma nova linha centralizada -->
        </c:if>
    </c:forEach>
</div>

<script>
    // Função para exibir o pop-up
    function mostrarPopup() {
        var popup = document.getElementById("popup");
        popup.style.display = "block";
    }

    // Função para fechar o pop-up
    function fecharPopup() {
        var popup = document.getElementById("popup");
        popup.style.display = "none";
    }
</script>

<script src="webjars/bootstrap/5.3.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>
