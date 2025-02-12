document.getElementById('formCliente').addEventListener('submit', async function (event) {
    event.preventDefault();

    const nome = document.getElementById('nome').value;
    const email = document.getElementById('email').value;
    const senha = document.getElementById('senha').value;
    const cpf = document.getElementById('cpf').value;
    const apelido = document.getElementById('apelido').value;

    const clienteData = {
        email: email,
        senha: senha,
        role: "CLIENTE",
        cpf: cpf,
        apelido: apelido
    };

    try {
        const response = await axios.post("http://localhost:8080/clientes", clienteData);
        if (response.status === 201) {
            alert("Cliente registrado com sucesso!");
            window.location.href = "/login.html"
        }
    } catch (error) {
        alert('Erro ao registrar o cliente. Tente novamente.');
        console.error(error);
    }
});
