# Contrato da API — J.L. Acervo

**Projeto:** J.L. Acervo  
**Sprint:** 1  
**Backend:** Java com Spring Boot  
**Comunicação:** API REST via HTTP  
**Formato dos dados:** JSON  
**Banco de dados:** MySQL

## 1. Objetivo

Este documento define os padrões de comunicação entre o frontend e o backend do J.L. Acervo.

Seu objetivo é estabelecer as rotas, os métodos HTTP, os formatos dos dados enviados e recebidos e as respostas esperadas pela API, garantindo que os integrantes da equipe desenvolvam suas funcionalidades seguindo um padrão comum.

## 2. Padrões gerais

- Todas as rotas da API deverão utilizar o prefixo `/api`.
- A comunicação entre frontend e backend será realizada por meio do protocolo HTTP.
- Os dados serão transmitidos no formato JSON.
- As requisições que enviarem dados deverão utilizar o cabeçalho `Content-Type: application/json`.
- Os nomes dos atributos no JSON deverão seguir o padrão camelCase.
- O backend será desenvolvido utilizando Java com Spring Boot.
- A persistência dos dados será realizada no banco de dados MySQL.
- A porta inicialmente prevista para execução do backend será `8080`.

## 3. Rotas da API

### 3.1. Cadastro de livros

**Método HTTP:** `POST`

**Rota:** `/api/livros`

**Descrição:** Responsável por receber os dados de um livro enviados pelo frontend, realizar as validações necessárias e solicitar seu armazenamento no banco de dados.

### 3.2. Listagem de livros

**Método HTTP:** `GET`

**Rota:** `/api/livros`

**Descrição:** Responsável por consultar os livros armazenados no banco de dados e disponibilizar os registros ao frontend.

## 4. Estrutura dos dados

O objeto Livro será representado pelos seguintes atributos:

| Atributo | Tipo JSON | Descrição |
|---|---|---|
| `titulo` | String | Título do livro |
| `autor` | String | Nome do autor |
| `anoPublicacao` | Number | Ano de publicação |
| `genero` | String | Gênero literário |

## 5. Exemplos de requisições e respostas

### 5.1. Cadastro de livro — POST

**Requisição:**

`POST /api/livros`

**Corpo da requisição:**

```json
{
  "titulo": "Dom Casmurro",
  "autor": "Machado de Assis",
  "anoPublicacao": 1899,
  "genero": "Romance"
}
```

**Resposta de sucesso — `201 Created`:**

```json
{
  "mensagem": "Livro cadastrado com sucesso!",
  "livro": {
    "titulo": "Dom Casmurro",
    "autor": "Machado de Assis",
    "anoPublicacao": 1899,
    "genero": "Romance"
  }
}
```

**Respostas esperadas:**

| Código HTTP | Significado |
|---|---|
| `201 Created` | Livro cadastrado com sucesso |
| `400 Bad Request` | Dados inválidos |
| `500 Internal Server Error` | Erro interno no servidor |

### 5.2. Listagem de livros — GET

**Requisição:**

`GET /api/livros`

**Resposta de sucesso — `200 OK`:**

```json
[
  {
    "titulo": "Dom Casmurro",
    "autor": "Machado de Assis",
    "anoPublicacao": 1899,
    "genero": "Romance"
  }
]
```

Caso não existam livros cadastrados, a API deverá retornar uma lista vazia (`[]`).

**Respostas esperadas:**

| Código HTTP | Significado |
|---|---|
| `200 OK` | Consulta realizada com sucesso |
| `500 Internal Server Error` | Erro interno no servidor |

## 6. Tratamento de erros

Quando uma requisição apresentar dados inválidos, o backend deverá retornar o código HTTP correspondente e uma mensagem que permita ao frontend informar o usuário sobre o problema.

**Exemplo de resposta — `400 Bad Request`:**

```json
{
  "mensagem": "O título do livro não pode estar vazio."
}
```

As mensagens deverão ser claras e compreensíveis, permitindo identificar o motivo da rejeição da requisição.

Erros inesperados durante o processamento deverão retornar `500 Internal Server Error`.

## 7. Fluxo de comunicação

1. O usuário preenche o formulário no frontend.
2. O JavaScript coleta e organiza os dados do livro.
3. O frontend envia uma requisição HTTP para a API.
4. O Spring Boot recebe e processa a requisição.
5. O backend executa as validações necessárias.
6. Os dados válidos são armazenados no MySQL.
7. A API retorna uma resposta ao frontend.
8. O frontend apresenta o resultado ao usuário e atualiza a listagem.

## 8. Responsabilidades

| Integrante | Responsabilidade |
|---|---|
| Guilherme | Definição do contrato e integração com o frontend |
| Rian | Implementação do cadastro de livros (POST) |
| Eduardo | Implementação da listagem de livros (GET) |
| Heitor | Banco MySQL e persistência dos dados |
| Matheus Silva | Validações e testes dos dados |
| Matheus de Paula | Integração e testes de ponta a ponta |

## 9. Observações

- A porta inicialmente prevista para execução do backend é `8080`, sujeita à confirmação da equipe.
- Os exemplos apresentados representam o contrato proposto para a Sprint 1.
- Alterações nas rotas, atributos ou respostas deverão ser alinhadas entre os integrantes.
- Este documento deverá ser atualizado caso ocorram mudanças aprovadas no contrato.