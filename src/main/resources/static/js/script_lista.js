const tabela = document.querySelector('.tabela');
let totalPaginas = 0;

async function conectarApi(url){
    const conexao = await fetch(url);
    const json = await conexao.json();
    totalPaginas = await json.totalPages;
    return json.content;
}


async function conectarApiBuscar(texto){
    const conexao = await fetch("http://localhost:8080/pianoBarApi/buscar/" + texto);
    const json = await conexao.json();
    totalPaginas = await json.totalPages;
    return json;
}


async function buscar(){
    const texto = document.querySelector(".pesquisa").value;
    console.log(texto);
    if(texto === ""){
        await ordenar("http://localhost:8080/pianoBarApi/data");
    }else{
        const linhaApi = await conectarApiBuscar(texto);
        tabela.innerHTML = `<tbody class="tabela">
        </tbody>`
        linhaApi.forEach(reserva => criarLinha(reserva.nome, reserva.cpf, reserva.data, reserva.mesa))
        await criarBotoesNavegacao();
    }   
}


function criarLinha(nome, cpf, data, mesa){
    const linha = document.createElement("tr");
    linha.innerHTML = `<tr class="linha">
    <td>${nome}</td>
    <td>${cpf}</td>
    <td>${data}</td>
    <td>${mesa}</td>
    </tr>`;
    tabela.appendChild(linha);
}


async function ordenar(url){
    const linhaApi = await conectarApi(url);
    tabela.innerHTML = `<tbody class="tabela">
    </tbody>`
    linhaApi.forEach(reserva => criarLinha(reserva.nome, reserva.cpf, reserva.data, reserva.mesa))
    await criarBotoesNavegacao();
}



async function criarBotoesNavegacao(){
    const botoes = document.querySelector(".botoes");
    botoes.innerHTML = `<div class="btn-group me-2 botoes" role="group" aria-label="First group">
    </div>`
    let contador = 0;
    while(contador < totalPaginas){
        const botao = document.createElement('button');
        botao.className = "btn btn-primary botao";
        botao.type = "button";
        botao.textContent = contador+1;
        botao.addEventListener('click', async function(){
            await ordenar(`http://localhost:8080/pianoBarApi/data?page=${this.textContent - 1}`);
        });
        botoes.appendChild(botao);
        contador = contador + 1;
    }
}

ordenar("http://localhost:8080/pianoBarApi/data");