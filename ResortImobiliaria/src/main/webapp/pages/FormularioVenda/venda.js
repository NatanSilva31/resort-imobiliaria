document.addEventListener("DOMContentLoaded", function() {
    const form = document.getElementById("booking-form");

    form.addEventListener("submit", function(event) {
        event.preventDefault(); // Impede o envio real do formulário para fins de demonstração

        const name = document.getElementById("name").value.trim();
        const email = document.getElementById("email").value.trim();
        const date = document.getElementById("date").value.trim();
        const property = document.getElementById("property").value.trim();

        // Obtém a data atual
        const currentDate = new Date();
        currentDate.setHours(0, 0, 0, 0); // Define a hora para meia-noite

        // Analisa a data selecionada do campo de entrada
        const selectedDate = new Date(date);

        if (!name || !email || !date || property === "") {
            alert("Por favor, preencha todos os campos.");
        } else if (selectedDate < currentDate) {
            alert("A data selecionada não pode ser retroativa. Por favor, escolha uma data futura.");
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
