document.getElementById('contactForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Evita o envio padrão do formulário

    // Validação do campo de e-mail
    var emailInput = document.getElementById('email');
    var emailError = document.getElementById('email-error');

    if (emailInput.value.trim() === '') {
        emailError.textContent = 'O campo de e-mail é obrigatório!';
        emailError.style.display = 'block';
        return; // Impede o envio do formulário se o campo de e-mail estiver vazio
    } else {
        emailError.textContent = '';
        emailError.style.display = 'none';
    }

    // Exibe a mensagem de confirmação
    document.getElementById('confirmation-message').style.display = 'block';

    // Limpa os campos preenchidos
    document.getElementById('contactForm').reset();
});