const listaLivros = document.querySelector("#lista-livros");

const livros = [
    {
    titulo: "O senhor dos Anéis",
    autor: "J.R.R. Tolkien",
    ano: 1954,
    genero: "Fantasia"
    },
    {
    titulo: "Dom Casmurro",
    autor: "Machado de Assis",
    ano: 1899,
    genero: "Romance"
    }
];

function renderizarLivros() {

    listaLivros.innerHTML = "";

    livros.forEach((livro) => {

    const card = document.createElement("div");
    card.classList.add("card-livro");

    card.innerHTML = `
        <h3>${livro.titulo}</h3>
        <p>Autor: ${livro.autor}</p>
        <p>Ano: ${livro.ano}</p>
        <p>Gênero: ${livro.genero}</p>
    `;

    listaLivros.appendChild(card);
    });
}
renderizarLivros();




const formulario = document.querySelector("#formulario-livro");

formulario.addEventListener("submit", async (event) => {
    event.preventDefault();


    const dados = new FormData(formulario);

    const livro = {
        titulo: dados.get("titulo"),
        autor: dados.get("autor"),
        ano: Number(dados.get("ano")),
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
