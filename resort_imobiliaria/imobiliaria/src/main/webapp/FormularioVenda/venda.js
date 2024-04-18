document.addEventListener("DOMContentLoaded", function() {
    const form = document.getElementById("booking-form");

    form.addEventListener("submit", function(event) {
        event.preventDefault(); // Previne o envio real do formulário para demonstração

        const name = document.getElementById("name").value.trim();
        const email = document.getElementById("email").value.trim();
        const date = document.getElementById("date").value.trim();
        const property = document.getElementById("property").value.trim();

        if (!name || !email || !date || property === "") {
            alert("Por favor, preencha todos os campos.");
        } else {
            // Exibe a notificação
            const notification = document.getElementById("notification");
            notification.style.display = "block";

            // Oculta a notificação após 3 segundos
            setTimeout(function() {
                notification.style.display = "none";
            }, 3000);

            // Aqui você pode adicionar o código para processar/enviar o formulário
            console.log("Formulário enviado com sucesso!");
        }
    });
});
