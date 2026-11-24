package br.edu.ifgoiano.jlacervo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifgoiano.jlacervo.model.Livro;
import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    // Busca livros como título OU autor
    // O Spring Data gera o SQL a partir do nome do método: LIKE %texto% no título OU no autor.
    List<Livro> findByTituloContainingIgnoreCaseOrAutorContainingIgnoreCase(String titulo, String autor);
}