package br.edu.ifgoiano.jlacervo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifgoiano.jlacervo.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}