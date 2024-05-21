<!DOCTYPE html>
<html>
<head>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <link href="./vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="./Styles/Dashboard/style.css">
    <meta charset="UTF-8">
    <title>Dashboard</title>

</head>
<body>

    <header class="navbar navbar-dark sticky-top bg-light flex-md-nowrap p-0 shadow">
    		<a class="navbar-brand col-md-3 col-lg-2 me-0 px-3 fs-6" href="/HomeLogada" style="color: black;">Dashboard - Imobiliaria</a>
    		<button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
    			<span class="navbar-toggler-icon"></span>
    		</button>

    </header>

    <div class="container-fluid">

        <div class="row">

            <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">

        				<div class="position-sticky pt-3 sidebar-sticky">


        					<ul class="nav flex-column">
        						<li class="nav-item">
        							<a class="nav-link" aria-current="page" href="./index.html"><span data-feather="home" class="align-text-bottom"></span> Home </a>
        						</li>
        						<li class="nav-item">
        							<a class="nav-link" href="/cadastroImovel"><span data-feather="file-text" class="align-text-bottom"></span> Nova Casa</a>
        						</li>
                                <li class="nav-item">
        							<a class="nav-link" href="/HomeLogada"><span data-feather="file" class="align-text-bottom"></span> Todos Imoveis</a>
        						</li>
        					</ul>

        				</div>
            </nav>
        	<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">

                    <h2>Imoveis</h2>

                  <div class="table-responsive">
                        <table class="table table-striped table-sm">
                            <tr>
                                <th>Id</th>
                                <th>Nome do Imovel</th>
                                <th>Endereco</th>
                                <th>Numero de Quartos</th>
                                <th>Numero de Banheiros</th>
                                <th>Numero de Vagas</th>
                                <th>Valor por Noite</th>
                                <th>Imagens</th>
                                <th>Email</th>
                                <th>Telefone</th>
                                <th>Observacoes</th>

                                <th>Acoes</th>
                            </tr>
                                <tr>
                                <c:forEach var="cadastro" items="${cadastroImov}">
                                 <c:if test="${cadastro.idUser == idUser}">
                                    <td>${cadastro.idCadastroImovel}</td>
                                    <td >${cadastro.tituloImovel}</td>
                                    <td>${cadastro.endereco}</td>
                                    <td>${cadastro.numQuartos}</td>
                                    <td>${cadastro.numBanheiro}</td>
                                    <td>${cadastro.numVagas}</td>
                                    <td>${cadastro.valorNoite}</td>
                                    <td>${cadastro.imagens}</td>
                                    <td>${cadastro.email}</td>
                                    <td>${cadastro.telefone}</td>
                                    <td>${cadastro.obs}</td>
                                    <td>
                                        <form action="/delete-cadastroImovel" method="post">
                                            <input type="hidden" id="id" name="id" value="${cadastro.idCadastroImovel}">
                                            <button type="submit" class="btn btn-outline-danger">Delete</button>
                                            <a class="btn btn-outline-success" href="cadastroImovel.jsp?idCadastroImovel=${cadastro.idCadastroImovel}&name=${cadastro.tituloImovel}&endereco=${cadastro.endereco}&numquartos=${cadastro.numQuartos}&numbanheiro=${cadastro.numBanheiro}&numvagas=${cadastro.numVagas}&valornoite=${cadastro.valorNoite}&imagens=${cadastro.imagens}&Email=${cadastro.email}&telefone=${cadastro.telefone}&obs=${cadastro.obs}">Editar</a>
                                        </form>
                                    </td>
                                </tr>
                                </c:if>
                                </c:forEach>
                        </table>
                  </div>
            </main>
         </div>
     </div>

     <script src="http://localhost:8080/webjars/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
     <script src="./Styles/JS/feather.min.js"></script>
     <script src="./Styles/JS/feather.min.js"></script>
     <script src="./Styles/JS/dashboard.js"></script>

</body>
</html>