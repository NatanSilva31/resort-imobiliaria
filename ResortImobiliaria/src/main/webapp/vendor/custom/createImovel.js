document.addEventListener('DOMContentLoaded', () => {
    const cepInput = document.getElementById('cep');
    const logradouroInput = document.getElementById('endereco');
    const termosCheckbox = document.getElementById('form2Example3cg');
    const fileInput = document.getElementById('imputFile');

    async function consultarCEP() {
        const cep = cepInput.value.replace(/\D/g, '');

        if (cep.length !== 8) {
            exibirErro('Por favor, digite um CEP válido com 8 dígitos.');
            return;
        }

        try {
            const response = await fetch(`https://viacep.com.br/ws/${cep}/json/`);
            const data = await response.json();

            if (data.erro) {
                exibirErro('CEP não encontrado.');
            } else {
                logradouroInput.value = data.logradouro;
                document.getElementById('cidade').value = data.localidade;
                document.getElementById('uf').value = data.uf;
            }
        } catch (error) {
            console.error('Erro ao consultar o CEP:', error);
            exibirErro('Ocorreu um erro ao consultar o CEP. Por favor, tente novamente.');
        }
    }

    cepInput.addEventListener('keypress', async (event) => {
        if (event.key === 'Enter') {
            event.preventDefault();
            await consultarCEP();
        }
    });

    function exibirErro(mensagem) {
        var errorDiv = document.querySelector('.alert-danger');
        errorDiv.textContent = mensagem;
        errorDiv.classList.remove('visually-hidden');

        setTimeout(function () {
            errorDiv.classList.add('visually-hidden');
        }, 3000);
    }

    function verificarCampos() {
        var tipoImovel = document.getElementById("tipoImovel").value.trim();
        var tipoVenda = document.getElementById("tipoVenda").value.trim();
        var valor = document.getElementById("valor").value.trim();
        var endereco = document.getElementById("endereco").value.trim();
        var numero = document.getElementById("numero").value.trim();
        var cidade = document.getElementById("cidade").value.trim();
        var uf = document.getElementById("uf").value.trim();
        var cep = document.getElementById('cep').value.trim();
        var numQuartos = document.getElementById("numQuartos").value.trim();
        var numBanheiros = document.getElementById("numBanheiros").value.trim();
        var metrosQuadrados = document.getElementById("metrosQuadrados").value.trim();
        var descricaoImovel = document.getElementById("descricaoImovel").value.trim();

        if (tipoImovel === "" || tipoVenda === "" || valor === "" || endereco === "" || numero === "" || cidade === "" || uf === "" || cep === "" || numQuartos === "" || numBanheiros === "" || metrosQuadrados === "" || descricaoImovel === "") {
            exibirErro("Todos os campos são obrigatórios.");
            return null; // Retorna null em caso de campos em branco
        }

        return {
            tipoImovel: tipoImovel,
            tipoVenda: tipoVenda,
            valor: valor,
            endereco: endereco,
            numero: numero,
            cidade: cidade,
            uf: uf,
            cep: cep,
            numQuartos: numQuartos,
            numBanheiros: numBanheiros,
            metrosQuadrados: metrosQuadrados,
            descricaoImovel: descricaoImovel
        }
    }

    document.getElementById('enviaranuncio').addEventListener("click", async function () {
        console.log("Botão clicado!");

        if (!termosCheckbox.checked) {
            exibirErro("Por favor, leia e concorde com os termos e condições.");
            return;
        }

        var dados = verificarCampos();

        if (dados) {
            const formData = new FormData();

            // Adiciona dados do formulário ao FormData
            for (const key in dados) {
                formData.append(key, dados[key]);
            }

            // Adiciona imagens ao FormData
            for (let i = 0; i < fileInput.files.length; i++) {
                formData.append('fotos', fileInput.files[i]);
            }

            try {
                const response = await fetch('/create-imovel', {
                    method: 'POST',
                    body: formData,
                });

                if (response.ok) {
                    console.log("DADOS E IMAGENS ENVIADOS COM SUCESSO");
                    window.location.href = "/pages/profile.html";
                } else {
                    console.log('Erro ao enviar os dados e imagens:', response.statusText);
                    alert('Erro ao enviar os dados e imagens: ' + response.statusText);
                }
            } catch (error) {
                console.log('Erro ao enviar os dados e imagens:', error);
                alert('Erro ao enviar os dados e imagens: ' + error.message);
            }
        }
    });
});
