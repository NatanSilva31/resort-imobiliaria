//Função para realizar o Cadastro do Cliente, onde ele preencherá o nome, e-mail e senha. O sistema irá verificar
//se o e-mail informado já se encontra na base, se sim, apresentará um erro


function signup() {
    var name = document.getElementById('signup-name').value;
    var email = document.getElementById('signup-email').value;
    var password = document.getElementById('signup-password').value;

    // Verifica se o e-mail já está cadastrado
    if (localStorage.getItem('email') === email) {
        document.getElementById('signup-error').innerText = 'E-mail já cadastrado. Use outro e-mail.';
        return;
    }

    localStorage.setItem('name', name);
    localStorage.setItem('email', email);
    localStorage.setItem('password', password);

    // Limpa mensagem de erro
    document.getElementById('signup-error').innerText = '';

    // Exibe mensagem de sucesso
    document.getElementById('signup-success').innerText = 'Cadastro realizado com sucesso!';

    // Limpa os campos após o cadastro bem-sucedido
    document.getElementById('signup-name').value = '';
    document.getElementById('signup-email').value = '';
    document.getElementById('signup-password').value = '';
}

function signin() {
    var email = document.getElementById('signin-email').value;
    var password = document.getElementById('signin-password').value;

    var storedEmail = localStorage.getItem('email');
    var storedPassword = localStorage.getItem('password');

    if (email === storedEmail && password === storedPassword) {
        alert('Login bem-sucedido!');
        
        // Redireciona para index.html
        window.location.href = '../index.html';
        return false; // Evita o envio do formulário
    } else {
        alert('Credenciais inválidas. Tente novamente.');
        return false; // Evita o envio do formulário
    }
}