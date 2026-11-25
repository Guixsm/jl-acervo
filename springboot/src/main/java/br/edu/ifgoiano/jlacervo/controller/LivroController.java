package br.edu.ifgoiano.jlacervo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifgoiano.jlacervo.model.Livro;
import br.edu.ifgoiano.jlacervo.repository.LivroRepository;
import br.edu.ifgoiano.jlacervo.service.LivroService;

import org.springframework.web.bind.annotation.RequestParam;

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

    //lista os livros do MySQL. Lista vazia retorna [].
    @GetMapping
    public List<Livro> listarLivros(@RequestParam(name = "busca", required = false) String busca) {
        if (busca == null || busca.isBlank()) {
            return livroRepository.findAll();
        }
        return livroRepository.findByTituloContainingIgnoreCaseOrAutorContainingIgnoreCase(busca.trim(), busca.trim());
    }

    //mantido sem alterações.
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

    // Exclui um livro pelo id. 204 se excluiu, 404 se não existe.
    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirLivro(@PathVariable Long id) {
        try {
            livroService.excluirLivro(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException erro) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(erro.getMessage());
        }
    }
}