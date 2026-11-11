const listaLivros = document.querySelector("#lista-livros");

async function carregarLivros() {

    try {
        const resposta = await fetch("http://localhost:8080/api/livros");

        if (!resposta.ok) {
            throw new Error("Resposta da API: " + resposta.status);
        }

        const livros = await resposta.json();

        listaLivros.innerHTML = "";

        if (livros.length === 0) {
            listaLivros.textContent = "Nenhum livro cadastrado.";
            return;
        }

        livros.forEach((livro) => {

            const card = document.createElement("div");
            card.classList.add("card-livro");

            [
                ["h3", livro.titulo],
                ["p", "Autor: " + livro.autor],
                ["p", "Ano: " + livro.anoPublicacao],
                ["p", "Gênero: " + livro.genero]
            ].forEach(([tag, texto]) => {
                const elemento = document.createElement(tag);
                elemento.textContent = texto;
                card.appendChild(elemento);
            });

            listaLivros.appendChild(card);
        });

    } catch (erro) {
        console.error("Erro ao carregar livros:", erro);
        listaLivros.textContent = "Não foi possível carregar os livros. Verifique se o servidor está em execução.";
    }
}
carregarLivros();




const formulario = document.querySelector("#formulario-livro");

formulario.addEventListener("submit", async (event) => {
    event.preventDefault();


    const dados = new FormData(formulario);

    const livro = {
        titulo: dados.get("titulo"),
        autor: dados.get("autor"),
        anoPublicacao: Number(dados.get("ano")),
        genero: dados.get("genero")
    };

    try {
        const resposta = await fetch("http://localhost:8080/api/livros", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(livro)

    });

    if (resposta.ok) {
        alert("Livro cadastrado com sucesso!");
        formulario.reset();
    } else {
        alert("Não foi possível cadastrar o livro. Verifique os dados e tente novamente.");
    }

    } catch (erro) {
        console.error("Erro ao cadastrar livro:", erro);
        alert("Não foi possível conectar com o servidor. Tente novamente mais tarde.");
    }
});
