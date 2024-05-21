document.addEventListener("DOMContentLoaded", function () {
    function validarEmail(email) {
        var regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return regex.test(email);
    }

    // Função para exibir mensagens de erro
    function exibirErro(mensagem) {
        var errorDiv = document.querySelector('.alert-danger');
        errorDiv.textContent = mensagem;
        errorDiv.classList.remove('visually-hidden');

        setTimeout(function () {
            errorDiv.classList.add('visually-hidden');
        }, 3000);
    }

    // Função para verificar o login
    document.getElementById("loginButton").addEventListener("click", function () {
        var email = document.getElementById("e-mail").value;
        var password = document.getElementById("password").value;
        var errorDiv = document.querySelector('.alert-danger');

        // Limpa a mensagem de erro ao tentar fazer login novamente
        setTimeout(function () {
            errorDiv.classList.add('visually-hidden');
        }, 3000);

        // Verifica se os campos de e-mail e senha estão preenchidos
        if (email.trim() === "" || password.trim() === "") {
            exibirErro("Todos os campos são obrigatórios.");
        } else if (!validarEmail(email)) {
            exibirErro("Por favor, insira um e-mail válido.");
        } else {
            // Envia os dados para o servidor
            fetch('/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded',
                },
                body: 'email=' + encodeURIComponent(email) + '&password=' + encodeURIComponent(password),
            })
            .then(response => {
                if (response.ok) {
                    // Sucesso no login, redireciona para página de perfil
                    window.location.href = "/pages/profile.html";
                } else {
                    // Erro no login, extrai a mensagem de erro do HTML
                    return response.text();
                }
            })
            .catch(error => {
                console.error('Erro ao enviar os dados:', error);
                exibirErro('Erro ao enviar os dados: ' + error.message);
            })
            .then(errorMessage => {
                if (errorMessage) {
                    // Extrair a mensagem de erro do HTML
                    var errorText = extractError(errorMessage);
                    // Exibir a mensagem de erro para o usuário
                    exibirErro(errorText);
                }
            });
        }
    });

    // Função para extrair a mensagem de erro do HTML
    function extractError(htmlMessage) {
        var parser = new DOMParser();
        var doc = parser.parseFromString(htmlMessage, 'text/html');
        var h1Element = doc.querySelector('h1');
        if (h1Element) {
            return h1Element.textContent;
        } else {
            return "Ocorreu um erro desconhecido.";
        }
    }

    var campos = document.querySelectorAll('input[type="text"], input[type="email"], input[type="password"]');
    campos.forEach(function (campo) {
        campo.addEventListener("focus", function () {
            var errorDiv = document.querySelector('.alert-danger');
            errorDiv.classList.add('visually-hidden');
        });
    });
});

console.log("Login.js carregado!")