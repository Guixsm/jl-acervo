package br.edu.ifgoiano.jlacervo.service;

import org.springframework.stereotype.Service;

import br.edu.ifgoiano.jlacervo.model.Livro;

@Service
public class LivroService {

    public Livro cadastrarLivro(Livro livro) {

        // Verifica os dados recebidos
        livro.setTitulo(livro.getTitulo());
        livro.setAutor(livro.getAutor());
        livro.setAnoPublicacao(livro.getAnoPublicacao());
        livro.setGenero(livro.getGenero());

        return livro;
    }
}