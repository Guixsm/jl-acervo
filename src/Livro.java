public class Livro {
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private String genero;

    public Livro(String titulo, String autor, int anoPublicacao, String genero){

        if (titulo == null || titulo.isBlank()){
            throw new IllegalArgumentException ("O campo título não pode ficar vazio.");
        }

        if (autor == null || autor.isBlank()){
            throw new IllegalArgumentException ("O campo autor não pode ficar vazio.");
        }

        if (anoPublicacao <= 0){
            throw new IllegalArgumentException ("Ano inválido");
        }

        if (genero == null || genero.isBlank()){
            throw new IllegalArgumentException ("Gênero inválido.");
        }

        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.genero = genero;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getAutor(){
        return autor;
    }

    public int getAnoPublicacao(){
        return anoPublicacao;
    }
    
    public String getGenero(){
        return genero;
    }
}