package br.edu.ifgoiano.jlacervo.service;

import org.springframework.stereotype.Service;

import br.edu.ifgoiano.jlacervo.model.Livro;
import br.edu.ifgoiano.jlacervo.repository.LivroRepository;

@Service
public class LivroService {
    //repositorio utilizado para salvar os livro
    private final LivroRepository livroRepository;
    //recebe o Repository por injeção de dependência
    public LivroService(LivroRepository livroRepository){
        this.livroRepository = livroRepository;
    }
    public Livro cadastrarLivro(Livro livro) {

        // Verifica os dados recebidos
        livro.setTitulo(livro.getTitulo());
        livro.setAutor(livro.getAutor());
        livro.setAnoPublicacao(livro.getAnoPublicacao());
        livro.setGenero(livro.getGenero());
        //salva o livro no banco de dados
        return livroRepository.save(livro);
    }
}