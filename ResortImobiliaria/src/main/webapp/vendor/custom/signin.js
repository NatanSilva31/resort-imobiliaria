document.addEventListener("DOMContentLoaded", function () {
    function validarEmail(email) {
        var regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return regex.test(email);
    }

    function validarCPF(cpf) {
        cpf = cpf.replace(/[^\d]/g, '');

        if (cpf.length !== 11 || !/[0-9]{11}/.test(cpf)) {
            return false;
        }

        if (/^(\d)\1{10}$/.test(cpf)) {
            return false;
        }

        var soma = 0;
        for (var i = 0; i < 9; i++) {
            soma += parseInt(cpf.charAt(i)) * (10 - i);
        }
        var resto = soma % 11;
        var digitoVerificador1 = resto < 2 ? 0 : 11 - resto;

        soma = 0;
        for (var i = 0; i < 10; i++) {
            soma += parseInt(cpf.charAt(i)) * (11 - i);
        }
        resto = soma % 11;
        var digitoVerificador2 = resto < 2 ? 0 : 11 - resto;

        return parseInt(cpf.charAt(9)) === digitoVerificador1 && parseInt(cpf.charAt(10)) === digitoVerificador2;
    }

    function validarCNPJ(cnpj) {
        cnpj = cnpj.replace(/[^\d]/g, '');

        if (cnpj.length !== 14 || !/[0-9]{14}/.test(cnpj)) {
            return false;
        }

        if (/^(\d)\1{13}$/.test(cnpj)) {
            return false;
        }

        var peso = [5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2];
        var soma = 0;
        for (var i = 0; i < 12; i++) {
            soma += parseInt(cnpj.charAt(i)) * peso[i];
        }
        var resto = soma % 11;
        var digitoVerificador1 = resto < 2 ? 0 : 11 - resto;

        peso.unshift(6);
        soma = 0;
        for (var i = 0; i < 13; i++) {
            soma += parseInt(cnpj.charAt(i)) * peso[i];
        }
        resto = soma % 11;
        var digitoVerificador2 = resto < 2 ? 0 : 11 - resto;

        return parseInt(cnpj.charAt(12)) === digitoVerificador1 && parseInt(cnpj.charAt(13)) === digitoVerificador2;
    }

    function verificarCampos() {
        var nome = document.getElementById("nome").value.trim();
        var sobrenome = document.getElementById("sobrenome").value.trim();
        var email = document.getElementById("e-mail-cad").value.trim();
        var docSelect = document.getElementById("doc-select").value.trim();
        var senha = document.getElementById("password").value.trim();
        var radioCPF = document.getElementById("cpf");
        var radioCNPJ = document.getElementById("cnpj");

        if (nome === "" || sobrenome === "" || email === "" || docSelect === "" || senha === "") {
            exibirErro("Todos os campos são obrigatórios.");
            return null; // Retorna null em caso de campos em branco
        }

        if (!validarEmail(email)) {
            exibirErro("Por favor, insira um e-mail válido.");
            return null; // Retorna null em caso de e-mail inválido
        }

        if (isNaN(docSelect)) {
            exibirErro("O documento deve conter apenas números.");
            return null; // Retorna null em caso de documento inválido
        }

        if (radioCPF.checked && !validarCPF(docSelect)) {
            exibirErro("Por favor, insira um CPF válido.");
            return null; // Retorna null em caso de CPF inválido
        }

        if (radioCNPJ.checked && !validarCNPJ(docSelect)) {
            exibirErro("Por favor, insira um CNPJ válido.");
            return null; // Retorna null em caso de CNPJ inválido
        }

        // Retorna um objeto com os valores dos campos validados
        return {
            name: nome + " " + sobrenome,
            email: email,
            docPfPj: docSelect,
            password: senha
        };
    }

    function exibirErro(mensagem) {
        var errorDiv = document.querySelector('.alert-danger');
        errorDiv.textContent = mensagem;
        errorDiv.classList.remove('visually-hidden');

        setTimeout(function () {
            errorDiv.classList.add('visually-hidden');
        }, 3000);
    }

    document.querySelector('.btn-primary').addEventListener("click", function () {
        var dados = verificarCampos();
        if (dados) {
            var termosDeUso = document.getElementById("termosdeusuo").checked;
            if (!termosDeUso) {
                exibirErro("Por favor, concorde com os termos de uso.");
            } else {
                // Exibir dados no console antes de enviar
                console.log("Dados do formulário a serem enviados:");
                console.log(JSON.stringify({
                    "name": dados.nomeCompleto,
                    "email": dados.email,
                    "docPfPj": dados.docSelect,
                    "password": dados.senha
                }));

                // Enviar os dados para o servlet
                fetch('/create-user', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify(dados),
                })
                    .then(response => {
                        if (response.ok) {
                            console.log("Dados enviados com sucesso!");
                            window.location.href = "/pages/login.html";
                        } else {
                            console.log("Capturando o erro do backend...")
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
    // Event listener para os radio buttons
    var radioButtons = document.querySelectorAll('input[type="radio"]');
    radioButtons.forEach(function (radio) {
        radio.addEventListener("change", function () {
            var docSelectLabel = document.querySelector('label[for="doc-select"]');
            if (radio.value === "cpf") {
                docSelectLabel.textContent = "CPF";
            } else if (radio.value === "cnpj") {
                docSelectLabel.textContent = "CNPJ";
            }
        });
    });

    var campos = document.querySelectorAll('input[type="text"], input[type="email"], input[type="password"]');
    campos.forEach(function (campo) {
        campo.addEventListener("focus", function () {
            var errorDiv = document.querySelector('.alert-danger');
            errorDiv.classList.add('visually-hidden');
        });
    });
});
