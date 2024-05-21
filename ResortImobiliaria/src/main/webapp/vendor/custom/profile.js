console.log("profile.js carregado! \n");

document.addEventListener("DOMContentLoaded", function () {
    // Função para obter os dados do usuário
    function obterDadosUsuario() {
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.readyState === XMLHttpRequest.DONE) {
                if (xhr.status === 200) {
                    var userData = JSON.parse(xhr.responseText);
                    atualizarPerfil(userData);
                } else {
                    console.error('Erro ao obter os dados do usuário.');
                }
            }
        };
        xhr.open('GET', '/profile', true);
        xhr.send();
    }

    // Função para atualizar o perfil na página
    function atualizarPerfil(userData) {
        document.getElementById('nome').textContent = userData.name;
        document.getElementById('nome2').textContent = userData.name;
        document.getElementById('email').textContent = userData.email;
        // Adicione outras linhas de código semelhantes para atualizar outros campos, se necessário
    }

    // Chamada da função para obter os dados do usuário quando a página é carregada
    obterDadosUsuario();


    function mostrarDadosUsuario() {
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.readyState === XMLHttpRequest.DONE) {
                if (xhr.status === 200) {
                    var userData = JSON.parse(xhr.responseText);
                    console.log("ID: " + userData.id);
                    console.log("Nome: " + userData.name);
                    console.log("Email: " + userData.email);
                    console.log("CPF/CNPJ: " + userData.cpf_cnpj);
                } else {
                    console.error('Erro ao obter os dados do usuário.');
                }
            }
        };
        xhr.open('GET', '/profile', true);
        xhr.send();
    }

    // Direcionando Click do btn "Anunciar" na Header.
    document.getElementById("AnunciarHeaderProfile").addEventListener("click", function() {
            window.location.href = "/pages/imovel.html"
    });

    // Chame esta função para buscar e mostrar os dados do usuário
    mostrarDadosUsuario();
});
