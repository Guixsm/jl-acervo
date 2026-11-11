# J.L. Acervo

Sistema web de gerenciamento de biblioteca desenvolvido como projeto acadêmico da disciplina de Programação Orientada a Objetos (POO), com o objetivo de cadastrar e consultar livros de um acervo.

## Objetivo

Desenvolver uma aplicação web que permita o gerenciamento de livros de um acervo, utilizando uma arquitetura cliente-servidor, aplicando conceitos de programação orientada a objetos, desenvolvimento web, APIs REST e persistência de dados.

## Funcionalidades

O projeto prevê as seguintes funcionalidades:

- Cadastro de livros com título, autor, ano de publicação e gênero literário.
- Listagem dos livros cadastrados.
- Validação dos dados informados.
- Armazenamento dos registros em banco de dados MySQL.
- Comunicação entre frontend e backend por meio de uma API REST.

**Observação:** as funcionalidades estão em desenvolvimento. A disponibilidade de cada operação depende da conclusão e integração dos respectivos componentes.

## Tecnologias utilizadas

**Frontend**
- HTML5
- CSS3
- JavaScript

**Backend**
- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- Maven

**Banco de dados**
- MySQL

**Ferramentas**
- Git e GitHub
- MySQL Workbench

## Arquitetura do projeto

O sistema utiliza uma arquitetura cliente-servidor, na qual o frontend é responsável pela interface e interação com o usuário, enquanto o backend processa as requisições, executa as regras de negócio e realiza a comunicação com o banco de dados.

A comunicação entre os componentes ocorre por meio de uma API REST, utilizando requisições HTTP e dados no formato JSON.

## Estrutura do projeto

```text
jl-acervo/
│
├── docs/
│   ├── CONTRATO_API.md
│   └── banco.sql
│
├── frontend/
│   ├── index.html
│   ├── script.js
│   └── style.css
│
├── springboot/
│   ├── .mvn/
│   ├── src/
│   ├── mvnw
│   ├── mvnw.cmd
│   └── pom.xml
│
├── .gitignore
└── README.md
```

- `frontend/`: contém os arquivos responsáveis pela interface do sistema.
- `springboot/`: contém a aplicação backend desenvolvida com Java e Spring Boot.
- `docs/`: reúne a documentação técnica e os scripts relacionados ao projeto.

## Configuração e execução

### Pré-requisitos

Antes de executar o projeto, é necessário possuir:

- JDK 21 ou compatível.
- MySQL instalado e em execução.
- Git, caso deseje clonar o repositório.

### 1. Clonar o repositório

```bash
git clone https://github.com/Guixsm/jl-acervo.git
cd jl-acervo
```

### 2. Configurar o banco de dados

O projeto utiliza MySQL para armazenar os registros de livros.

Execute o script `docs/banco.sql` utilizando o MySQL Workbench ou outro cliente MySQL compatível.

Esse script cria o banco de dados `jlacervo` e a tabela `livro`, caso ainda não existam.

### 3. Configurar as variáveis de ambiente

As credenciais de acesso ao banco são obtidas por meio de variáveis de ambiente, evitando que sejam armazenadas diretamente no código-fonte.

No Windows (PowerShell):

```powershell
$env:DB_USER="seu_usuario"
$env:DB_PASSWORD="sua_senha"
```

A variável `DB_URL` é opcional. Caso não seja definida, a aplicação utilizará o endereço padrão:

```text
jdbc:mysql://localhost:3306/jlacervo
```

### 4. Executar o backend

A partir da raiz do repositório, acesse o diretório do Spring Boot:

**Windows (PowerShell):**

```powershell
cd springboot
.\mvnw.cmd spring-boot:run
```

**Linux/macOS:**

```bash
cd springboot
./mvnw spring-boot:run
```

O backend está configurado para utilizar a porta `8080`.

### 5. Executar o frontend

Abra o arquivo `frontend/index.html` em um navegador.

O frontend realiza a comunicação com o backend por meio das requisições HTTP definidas no contrato da API.

**Observação:** a execução integrada depende de o backend estar iniciado e de a configuração de conexão com o banco de dados estar correta.

## Comunicação com a API

O frontend se comunica com o backend por meio de uma API REST desenvolvida com Spring Boot. As requisições e respostas utilizam o formato JSON.

O contrato da API especifica as seguintes operações:

| Método | Endpoint | Finalidade |
|---|---|---|
| POST | `/api/livros` | Cadastrar livros |
| GET | `/api/livros` | Consultar livros cadastrados |

Para consultar os formatos das requisições, respostas HTTP, atributos e regras de comunicação, acesse o [Contrato da API](docs/CONTRATO_API.md).

## Documentação complementar

O projeto possui documentação técnica adicional no diretório `docs/`:

- [Contrato da API](docs/CONTRATO_API.md): descreve os endpoints, métodos HTTP, formatos de requisição e respostas da API REST.
- [Script do banco de dados](docs/banco.sql): contém os comandos SQL utilizados na configuração inicial do banco de dados MySQL.

## Contexto acadêmico

Projeto desenvolvido em equipe para a disciplina de Programação Orientada a Objetos (POO), com foco na aplicação de conceitos de programação orientada a objetos, desenvolvimento de aplicações web, integração de sistemas e persistência de dados.

## Equipe

Projeto desenvolvido por estudantes do Bacharelado em Ciência da Computação do IF Goiano — Campus Iporá.
