import java.util.ArrayList;
import java.util.List; /*permite usar a interface List como retorno */

public class Acervo {
    private ArrayList<Livro> livros = new ArrayList<>();


    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public List<Livro> getLivros() {  /* para permitir que a interface gráfica consulte os livros armazenados */
        return new ArrayList<>(livros); /* usando List<Livro> como tipo de retorno, ele devolve uma cópia da lista */
    }
}


