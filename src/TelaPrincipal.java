import javax.swing.*;
import java.awt.*;

public class TelaPrincipal extends JFrame {

    private final Acervo acervo = new Acervo();

    private final JTextField campoTitulo = new JTextField();
    private final JTextField campoAutor = new JTextField();
    private final JTextField campoAno = new JTextField();
    private final JTextField campoGenero = new JTextField();

    private final JTextArea areaLivros = new JTextArea();

    public TelaPrincipal() {
        setTitle("J.L Acervo");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10,10));

        JPanel formulario = new JPanel(new GridLayout(0, 2, 8, 8));

        formulario.add(new JLabel("Título:"));
        formulario.add(campoTitulo);

        formulario.add(new JLabel("Autor:"));
        formulario.add(campoAutor);

        formulario.add(new JLabel("Ano de publicação:"));
        formulario.add(campoAno);

        formulario.add(new JLabel("Gênero:"));
        formulario.add(campoGenero);

        JButton botaoCadastrar = new JButton("Cadastrar livro");
        formulario.add(botaoCadastrar);

        areaLivros.setEditable(false);

        add(formulario, BorderLayout.NORTH);
        add( new JScrollPane(areaLivros), BorderLayout.CENTER);

        botaoCadastrar.addActionListener(e -> cadastrarLivro());
     }

     private void cadastrarLivro(){
        try {
            String titulo = campoTitulo.getText();
            String autor = campoAutor.getText();
            int ano = Integer.parseInt(campoAno.getText());
            String genero = campoGenero.getText();

            Livro livro = new Livro(titulo, autor, ano, genero);
            acervo.adicionarLivro(livro);

            atualizarLista();

            JOptionPane.showMessageDialog(this, "Livro cadastrado com sucesso!");

            campoTitulo.setText("");
            campoAutor.setText("");
            campoAno.setText("");
            campoGenero.setText("");

        } catch (NumberFormatException erro) {
            JOptionPane.showMessageDialog(this, "Digite um ano válido.");
        } catch (IllegalArgumentException erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
     }

     private void atualizarLista() {
        areaLivros.setText("");

        for (Livro livro : acervo.getLivros()) {
            areaLivros.append(
                "Título: " + livro.getTitulo()
                + "\nAutor: " + livro.getAutor()
                + "\nAno: " + livro.getAnoPublicacao()
                + "\nGênero: " + livro.getGenero()
                + "\n--------------------------\n"
            );
        }
     }
}
