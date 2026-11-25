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

    //edita os dados de livro cadastrado
    public Livro editarLivro(Long id, Livro novosDados) {

        // Procura o livro pelo ID.
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() ->
                    new java.util.NoSuchElementException("Livro não encontrado."));

        // Atualiza os dados do livro existente.
        livro.setTitulo(novosDados.getTitulo());
        livro.setAutor(novosDados.getAutor());
        livro.setAnoPublicacao(novosDados.getAnoPublicacao());
        livro.setGenero(novosDados.getGenero());

        // Salva as alterações no banco de dados.
        return livroRepository.save(livro);
    }

}