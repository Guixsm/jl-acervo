public class Livro{
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private String genero;

    public Livro(String titulo, String autor, int anoPublicacao, String genero){
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
    
    public void setTitulo(String titulo){
        if (titulo == null || titulo.isBlank()){
            throw new IllegalArgumentException ("O campo título não pode ficar vazio.");
        }else{
            this.titulo = titulo;
        }
    }
    public void setAutor(String autor){
        if (autor == null || autor.isBlank()){
            throw new IllegalArgumentException ("O campo autor não pode ficar vazio.");
        }else{
            this.autor = autor;
        }
    }
    public void setAnoPublicacao(int anoPublicacao){
        if (anoPublicacao <= 0){
            throw new IllegalArgumentException ("Ano inválido");
        }else{
            this.anoPublicacao = anoPublicacao;
        }
    }
    public void setGenero(String genero){
        if (genero == null || genero.isBlank()){
            throw new IllegalArgumentException ("Gênero inválido.");
        }else{
            this.genero = genero;
        }
    }
     public void ficha(){
        System.out.println("Titulo: " + this.titulo);
        System.out.println("Autor: " + this.autor);
        System.out.println("AnoPublicacao: " + this.anoPublicacao);
        System.out.println("Genero: " + this.genero);
    }
}
