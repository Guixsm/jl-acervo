# J.L. Acervo

Sistema de gerenciamento de biblioteca desenvolvido em Java com interface gráfica Swing, como projeto acadêmico da disciplina de Programação Orientada a Objetos (POO).

## Objetivo

Desenvolver uma aplicação desktop simples para cadastrar e consultar os livros de um acervo, aplicando conceitos fundamentais de programação orientada a objetos.

## Funcionalidades

- Cadastro de livros com título, autor, ano de publicação e gênero literário.
- Listagem dos livros cadastrados na interface gráfica.
- Validação de campos obrigatórios.
- Validação do ano de publicação.
- Mensagens de sucesso e de erro durante as operações.

**Observação:** os livros são mantidos em memória durante a execução. Os dados não são persistidos após o encerramento da aplicação.

## Tecnologias utilizadas

- Java 21
- Java Swing
- Git e GitHub

## Estrutura do projeto

- `Main.java`: inicializa a aplicação.
- `Livro.java`: representa um livro e valida seus dados.
- `Acervo.java`: gerencia a coleção de livros.
- `TelaPrincipal.java`: implementa a interface gráfica e as operações de cadastro.
- `TesteLivro.java`: permite testar a criação de um livro e a leitura de seus atributos.

## Como executar

### Pré-requisitos

- JDK 21 ou compatível instalado.
- Git, caso deseje clonar o repositório.

### Compilação

Na pasta raiz do projeto, execute:

```powershell
javac -encoding UTF-8 -d out src\*.java
```

### Execução

Após a compilação, execute:

```powershell
java -cp out Main
```

## Testes realizados

Durante o desenvolvimento, foram verificados:

- Cadastro de livros com dados válidos.
- Exibição de múltiplos livros na lista.
- Rejeição de campos obrigatórios vazios.
- Tratamento de valores não numéricos no ano de publicação.
- Exibição de mensagens de sucesso e erro.

## Contexto acadêmico

Projeto desenvolvido para a disciplina de Programação Orientada a Objetos, com foco na aplicação de classes, objetos, encapsulamento, construtores, validação de dados e interface gráfica.

## Equipe

Projeto desenvolvido em grupo. Os integrantes e suas respectivas responsabilidades devem ser identificados conforme a divisão de tarefas acordada pela equipe.

