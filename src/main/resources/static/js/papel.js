document.getElementById("btnAdmin").addEventListener("click", function() {
    escolherPapel("ADMIN");
});

document.getElementById("btnLojista").addEventListener("click", function() {
    escolherPapel("LOJISTA");
});

document.getElementById("btnCliente").addEventListener("click", function() {
    escolherPapel("CLIENTE");
});

function escolherPapel(papel) {
    axios.post("/api/registroPapel", { papel: papel })
        .then(function(response) {
            if (papel === "CLIENTE") {
                window.location.href = "registrarCliente.html";
            } else {
                window.location.href = `registrar${papel}.html`;
            }
        })
        .catch(function(error) {
            console.error("Erro ao enviar o papel: ", error);
            alert("Ocorreu um erro. Tente novamente.");
        });
}
