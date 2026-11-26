# Relatório de Testes de Integração — Sprint 2

**Testador:** Matheus de Paula Silva
**Ambiente:** Windows, MySQL 8.0, JDK 25.0.1, extensão Live Server
**Branch testada:** main

## Resumo

Todos os testes foram aprovados. Não houve incompatibilidades nem erros durante a execução correta.

## Resultados

| # | Teste | Como foi testado / Resultado obtido | Status |
|---|---|---|---|
| 1 | Conexão frontend → backend | Ao enviar o registro de um livro pelo front-end (Live Server), os dados foram guardados e puderam ser vistos com `curl.exe http://localhost:8080/api/livros`, exatamente como foram enviados. Nenhum erro foi apresentado no "inspecionar elemento" → "Console". | Aprovado |
| 2 | Cadastro via POST | Realizei o cadastro via `curl` e pelo front-end. Ambos deram o resultado esperado. | Aprovado |
| 3 | Persistência no MySQL | `SELECT * FROM livro;` no PowerShell mostrou todos os livros cadastrados. Após reiniciar o back-end todos os livros registrados ainda aparecem. | Aprovado |
| 4 | Consulta via GET | `curl.exe http://localhost:8080/api/livros` retornou todos os livros registrados. | Aprovado |
| 5 | Exibição na interface | Ao recarregar a página do front-end, todos os livros registrados apareceram na interface de forma organizada. | Aprovado |
| 6 | Dados inválidos | Dados inválidos não foram aceitos. Ao tentar envia-los e então ver os livros registrados, nada aconteceu, como deveria. | Aprovado |

# Relatório de Testes de Integração — Sprint 3

**Testador:** Matheus de Paula Silva
**Ambiente:** Windows, MySQL 8.0, JDK 25.0.1, extensão Live Server
**Branch testada:** main

## Resumo

Busca foi implementada corretamente. Exclusão e Edição ainda não foram adicionadas a branch, estando pendente.

## Resultados

| # | Teste | Como foi testado / Resultado obtido | Status |
|---|---|---|---|
| 1 | Busca com resultado | `curl.exe "http://localhost:8080/api/livros?busca=Dom"` retornou apenas os dois "Dom Casmurro". | Aprovado |
| 2 | Busca sem resultado | `curl.exe "http://localhost:8080/api/livros?busca=xyzxyz"` retornou `[]`. | Aprovado |
| 3 | Edição | `PUT /api/livros/9999` retornou 404. O `LivroController` da `main` não possui `@PutMapping`. | Não implementado |
| 4 | Exclusão | `DELETE /api/livros/9999` retornou 404. O `LivroController` da `main` não possui `@DeleteMapping`. | Não implementado |