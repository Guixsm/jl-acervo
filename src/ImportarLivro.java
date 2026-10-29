import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;


/// UTILIZE javac ImportarLivro.java + java ImportarLivro APÓS ABRIR O TERMINAL (APERTAR CTRL + ')
/// javac ImportarLivro.java
/// Java ImportarLivro
/// Resolver esse problema acima que eu não faço ideia do por que ocorre pode ser o pc da escola
/// CTRL + C -> Encerra o código no Terminal

public class ImportarLivro {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // Serve o formulário
        server.createContext("/", exchange -> {
            try {
                System.out.println(">>> Requisição recebida: " + exchange.getRequestMethod() + " " + exchange.getRequestURI());

                Path caminho = Path.of("formulario.html");
                System.out.println(">>> Procurando HTML em: " + caminho.toAbsolutePath());

                byte[] html = Files.readAllBytes(caminho);
                exchange.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
                exchange.sendResponseHeaders(200, html.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(html);
                }
                System.out.println(">>> Formulário enviado ao navegador");
            } catch (Exception e) {
                System.out.println(">>> ERRO ao servir o formulário:");
                e.printStackTrace();
                erro(exchange, e);
            }
        });

        // Recebe o POST do formulário
        server.createContext("/processa", exchange -> {
            try {
                String corpo = new String(exchange.getRequestBody().readAllBytes(), StandardCharsets.UTF_8);

                Map<String, String> params = new HashMap<>();
                for (String par : corpo.split("&")) {
                    if (par.isEmpty()) continue;
                    String[] kv = par.split("=", 2);
                    String chave = URLDecoder.decode(kv[0], StandardCharsets.UTF_8);
                    String valor = kv.length > 1 ? URLDecoder.decode(kv[1], StandardCharsets.UTF_8) : "";
                    params.put(chave, valor);
                }

                String titulo = params.get("Titulo");
                String autor = params.get("Autor");
                String anoStr = params.get("Ano");
                String genero = params.get("Genero");
                
                String resposta;
                int status;
                
                try {
                    int ano;
                    try {
                        ano = Integer.parseInt(anoStr.trim());
                    } catch (NumberFormatException | NullPointerException e) {
                        ano = 0;
                    }
                
                    Livro livro = new Livro(titulo, autor, ano, genero);
                
                    System.out.println(">>> Livro criado: " + livro.getTitulo()
                            + " | " + livro.getAutor()
                            + " | " + livro.getAnoPublicacao()
                            + " | " + livro.getGenero());
                
                    resposta = "<h3>Livro recebido!</h3>"
                            + "<p>Título: " + livro.getTitulo() + "</p>"
                            + "<p>Autor: " + livro.getAutor() + "</p>"
                            + "<p>Ano: " + livro.getAnoPublicacao() + "</p>"
                            + "<p>Gênero: " + livro.getGenero() + "</p>";
                    status = 200;
                /// Se Livro.Java encontrar algum erro ele é retornado para o Web através daqui.
                } catch (IllegalArgumentException e) {
                    resposta = "<h3>Erro</h3><p>" + e.getMessage() + "</p>";
                    status = 400;
                }
                
                byte[] bytes = resposta.getBytes(StandardCharsets.UTF_8);
                exchange.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
                exchange.sendResponseHeaders(status, bytes.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(bytes);
                }
                System.out.println(">>> Resposta enviada com sucesso");
            } catch (Exception e) {
                System.out.println(">>> ERRO ao processar o POST:");
                e.printStackTrace();
                erro(exchange, e);
            }
        });

        server.start();
        System.out.println("Servidor rodando em http://localhost:8080");
    }

    // Devolve o erro na própria página para facilitar o diagnóstico
    private static void erro(HttpExchange exchange, Exception e) {
        try {
            byte[] msg = ("Erro: " + e).getBytes(StandardCharsets.UTF_8);
            exchange.sendResponseHeaders(500, msg.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(msg);
            }
        } catch (IOException ignorado) {
        }
    }
}