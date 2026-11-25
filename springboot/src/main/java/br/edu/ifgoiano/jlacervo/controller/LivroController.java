
package br.edu.ifgoiano.jlacervo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifgoiano.jlacervo.model.Livro;
import br.edu.ifgoiano.jlacervo.repository.LivroRepository;
import br.edu.ifgoiano.jlacervo.service.LivroService;

@CrossOrigin(origins = {
    "http://localhost:5500",
    "http://127.0.0.1:5500"
})
@RestController
@RequestMapping("/api/livros")
public class LivroController {

    private final LivroService livroService;
    private final LivroRepository livroRepository;

    public LivroController(LivroService livroService, LivroRepository livroRepository) {
        this.livroService = livroService;
        this.livroRepository = livroRepository;
    }

    // GET: lista todos os livros ou pesquisa por título ou autor.
    @GetMapping
    public List<Livro> listarLivros(
            @RequestParam(name = "busca", required = false) String busca) {

        if (busca == null || busca.isBlank()) {
            return livroRepository.findAll();
        }

        return livroRepository.findByTituloContainingIgnoreCaseOrAutorContainingIgnoreCase(
                busca.trim(), busca.trim());
    }

    // POST: cadastra um novo livro.
    @PostMapping
    public ResponseEntity<?> cadastrarLivro(@RequestBody Livro livro) {
        try {
            Livro livroCadastrado = livroService.cadastrarLivro(livro);

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(livroCadastrado);

        } catch (IllegalArgumentException erro) {
            return ResponseEntity
                    .badRequest()
                    .body(erro.getMessage());
        }
    }

    // PUT: recebe o ID e os novos dados para livro
    @PutMapping("/{id}")
    public ResponseEntity<?> editarLivro(
            @PathVariable Long id,
            @RequestBody Livro livro) {

        try {
            //solicita ao Service 
            Livro livroAtualizado = livroService.editarLivro(id, livro);

            //retorna 200 quando atualizado
            return ResponseEntity.ok(livroAtualizado);

        } catch (NoSuchElementException erro) {
            //retorna 404 se não existe
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(erro.getMessage());

        } catch (IllegalArgumentException erro) {
            //retorna 400 se inválidos
            return ResponseEntity
                    .badRequest()
                    .body(erro.getMessage());
        }
    }

}
