async function login() {
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const message = document.getElementById('message');

    try {
        const response = await axios.post("http://localhost:8080/auth/login", {
            email: username,
            senha: password
        }, {
            headers: {
                "Content-Type": "application/json",
                "Accept": "application/json"
            }
        });

        localStorage.setItem("token", response.data.token);
        window.location.href = "/autenticado.html";
    } catch (error) {
        message.textContent = "Usuário ou senha inválidos";
        message.style.color = "red";
    }
}

