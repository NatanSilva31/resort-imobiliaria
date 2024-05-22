console.log("profile.js carregado! \n");

document.addEventListener("DOMContentLoaded", function () {
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

    function atualizarPerfil(userData) {
        document.getElementById('nome').textContent = userData.name;
        document.getElementById('nome2').textContent = userData.name;
        document.getElementById('email').textContent = userData.email;
    }

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

    document.getElementById("AnunciarHeaderProfile").addEventListener("click", function() {
            window.location.href = "/pages/imovel.html"
    });

    mostrarDadosUsuario();
});
