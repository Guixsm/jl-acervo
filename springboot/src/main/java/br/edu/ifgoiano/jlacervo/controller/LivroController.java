package br.edu.ifgoiano.jlacervo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    // GET /api/livros (Eduardo): lista os livros do MySQL. Lista vazia retorna [].
    @GetMapping
    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }

    // POST /api/livros (Rian): mantido sem alterações.
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
}