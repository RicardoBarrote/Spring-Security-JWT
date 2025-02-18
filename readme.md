
# Artigo sobre Spring Security 6 e JWT

Neste artigo abordamos uma autenticação stateless, utilizando Spring Security 6 + JWT, onde ensino o passo a passo para proteger sua API de forma segura.



## Stack utilizada

**Front-end:** Html, Css, JavaScript(Axios).

**Back-end:** Java, Spring Boot, Spring Security, Spring Web, Spring Data Jpa, MapStruct, Validation.

**Infra:** Maven, Docker

## github

Clonar o código

```bash
  git clone git@github.com:RicardoBarrote/Spring-Security-JWT.git
```

## Docker

Build do contêiner, caso o sistema operacional seja windows bastar subir sem o 'sudo'.
```Build
sudo docker-compose up --build -d
```

Caso já tenha feito o build e deseje subir o contêiner novamente, basta apenas utilizar o comando abaixo

```Docker
sudo docker-compose up -d
```
## 🔗 Link do artigo
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/pulse/protegendo-sua-api-com-spring-security-json-web-token-ricardo-barrote-gssxf/?trackingId=28V1Z6e%2FTne%2BFV7m4k4tWg%3D%3D)


## Documentação da API



### Administradores
#### Criar um usuário do tipo Administrador

```http
  POST /administradores
```

| body   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `email` | `string` | **Obrigatório**. Email do administrador |
| body   | Tipo       | Descrição                           |
| `senha` | `string` | **Obrigatório**. Senha do administrador |
| body   | Tipo       | Descrição                           |
| `nome` | `string` | **Obrigatório**. Nome do administrador |

### JSON
```JSON
{
    "email":"administradorTest@gmail.com",
    "senha":"123",
    "nome":"AdminTest"
}
```

Obs: Método não retorna um administrador no corpo, apenas salva no banco de dados.

Status: 201 CREATED
##


#### Retorna todos os Administradores registrado

```http
  GET /administradores
```

Este endpoint não recebe nada no parâmetro.

Retorna uma lista de administradores.

Status: 200 OK
##


### Retorna o administrador através do seu Id

```http
  GET /administradores/{id}
```
No caminho da URL repassamos o seu id.

Exemplo:

```URL
localhost:8080/administradores/c2745ba6-02b9-4ee3-8772-bd4fb9e73fe4
```
Neste caso o id está do tipo UUID, caso esteja atuando com microserviços não recomendo usar tipos inteiros.
##


#### Atualizar os dados de um Administrador

```http
  PUT /administradores
```

| body   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `nomeAntigo` | `string` | **Obrigatório**. informar o nome do administrador que vai ser atualizado |
| body   | Tipo       | Descrição                           |
| `email` | `string` | **Obrigatório**. Informar o email do administrador ou o novo email |
| body   | Tipo       | Descrição                           |
| `nome` | `string` | **Obrigatório**. Nome do administrador atualizado |

O campo nomeAntigo, iremos passar no parâmetro da requisição

```URL
localhost:8080/administradores?nomeAntigo=AdminTest
```

### JSON
```JSON
{
    "email":"administradorTest@gmail.com",
    "nome":"testDois"
}
```
Este endpoint vai retornar uma mensagem 'Atualizado com sucesso!', caso tudo ocorra de forma correta.

Status: 200 OK
##

### Deletar um administrador através do id


```http
  DELETE /administradores/{id}
```
No caminho da URL repassamos o seu id

Exemplo:

```URL
localhost:8080/administradores/c2745ba6-02b9-4ee3-8772-bd4fb9e73fe4
```

Status: 204 NO_CONTENT
##

### Cliente
#### Criar um usuário do tipo Cliente

```http
  POST /clientes
```

| body   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `email` | `string` | **Obrigatório**. Email do cliente |
| body   | Tipo       | Descrição                           |
| `senha` | `string` | **Obrigatório**. Senha do cliente |
| body   | Tipo       | Descrição                           |
| `cpf` | `string` | **Obrigatório**. cpf do cliente |
| body   | Tipo       | Descrição                           |
| `apelido` | `string` | **Obrigatório**. Apelido do cliente |

### JSON
```JSON
{
    "email":"clienteTest@gmail.com",
    "senha":"123",
    "cpf":"11588744530"
    "apelido":"clienteTest"
}
```

Obs: Este endpoint iremos salvar um novo usuário do tipo cliente em nossa base de dados.

Status: 201 CREATED
##


#### Retorna todos os clientes registrado

```http
  GET /clientes
```

Retorna uma lista de clientes.

Status: 200 OK
##


### Retorna um cliente através do seu Id

```http
  GET /clientes/{id}
```
No caminho da URL repassamos o seu id.

Exemplo:

```URL
localhost:8080/clientes/c2745ba6-02b9-4ee3-8772-bd4fb9e73fe4
```
##


#### Atualizar os dados de um cliente

```http
  PUT /clientes
```

| body   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `apelido` | `string` | **Obrigatório**. informar o aplido do cliente que vai ser atualizado |
| body   | Tipo       | Descrição                           |
| `emailAtualizado` | `string` | **Obrigatório**. Informar o email do cliente ou um novo email, caso deseje atuaizar |
| body   | Tipo       | Descrição                           |
| `apelidoAtualizado` | `string` | **Obrigatório**. Apelido do cliente atualizado |

O campo apelido, iremos passar no parâmetro da requisição

```URL
localhost:8080/clientes?apelido=NovoApelido
```

### JSON
```JSON
{
    "emailAtualizado":"apelido@gmail.com",
    "apelidoAtualizado":"apelidoTest"
}
```
Este endpoint vai retornar uma mensagem 'Atualizado com sucesso!', caso tudo ocorra de forma correta.

Status: 200 OK
##

### Deletar um cliente através do id


```http
  DELETE /clientes/{id}
```
No caminho da URL repassamos o seu id

Exemplo:

```URL
localhost:8080/clientes/c2745ba6-02b9-4ee3-8772-bd4fb9e73fe4
```

Status: 204 NO_CONTENT
##

### Lojista
#### Criar um usuário do tipo Lojista

```http
  POST /lojistas
```

| body   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `email` | `string` | **Obrigatório**. Email do Lojista |
| body   | Tipo       | Descrição                           |
| `senha` | `string` | **Obrigatório**. Senha do Lojista |
| body   | Tipo       | Descrição                           |
| `cnpj` | `string` | **Obrigatório**. cnpj do lojista |
| body   | Tipo       | Descrição                           |
| `razaosocial` | `string` | **Obrigatório**. razaosocial do lojista |

### JSON
```JSON
{
    "email":"lojistaTest@gmail.com",
    "senha":"123",
    "cnpj":"11588744530"
    "razaosocial":"razaotest"
}
```

Obs: Este endpoint iremos salvar um novo usuário do tipo Lojista em nossa base de dados.

Status: 201 CREATED
##


#### Retorna todos os lojistas registrado

```http
  GET /lojistas
```

Retorna uma lista de lojistas.

Status: 200 OK
##


### Retorna um lojista através do seu Id

```http
  GET /lojistas/{id}
```
No caminho da URL repassamos o seu id.

Exemplo:

```URL
localhost:8080/lojistas/c2745ba6-02b9-4ee3-8772-bd4fb9e73fe4
```
##


#### Atualizar os dados de um lojista

```http
  PUT /lojistas
```

| body   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `razaosocial` | `string` | **Obrigatório**. informar a razaosocial do lojista que vai ser atualizado |
| body   | Tipo       | Descrição                           |
| `emailAtualizado` | `string` | **Obrigatório**. Informar o email do lojista ou um novo email, caso deseje atuaizar |
| body   | Tipo       | Descrição                           |
| `razaosocialAtualizado` | `string` | **Obrigatório**. razaosocial do lojista atualizado |

O campo razaosocial, iremos passar no parâmetro da requisição

```URL
localhost:8080/lojistas?razaosocial=razaosocial
```

### JSON
```JSON
{
    "emailAtualizado":"lojista@gmail.com",
    "razaosocialAtualizado":"razaotest"
}
```
Este endpoint vai retornar uma mensagem 'Atualizado com sucesso!', caso tudo ocorra de forma correta.

Status: 200 OK
##

### Deletar um lojista através do id


```http
  DELETE /lojistas/{id}
```
No caminho da URL repassamos o seu id

Exemplo:

```URL
localhost:8080/lojistas/c2745ba6-02b9-4ee3-8772-bd4fb9e73fe4
```

Status: 204 NO_CONTENT
##