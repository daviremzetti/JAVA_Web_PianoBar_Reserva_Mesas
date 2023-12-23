const select = document.querySelector('.mesa');
const tabela = document.querySelector('.tabela');
let totalPaginas = 0;

async function conectarApi(){
    const data = document.querySelector(".data").value;
    const conexao = await fetch("http://localhost:8080/pianoBarApi/" + data);
    const json = await conexao.json();
    console.log(json);
    totalPaginas = await json.totalPages;
    return json;
}



function criarOpcoes(mesa){
    const opcao = document.createElement('option');
    opcao.innerHTML = `<option>${mesa}</option>`
    select.appendChild(opcao);
}

async function buscarMesasLivres(){
    const dadosApi = await conectarApi();
    dadosApi.forEach(mesa => criarOpcoes(mesa));
}

async function conectarApiReservaPost(nome, cpf, email, data, mesa){
    const conexao = await fetch("http://localhost:8080/pianoBarApi", {
        method: 'POST',
        headers:{
            'Content-Type': 'application/json; charset=UTF-8'
        },
        body: JSON.stringify({nome, cpf, email, data, mesa})
    });
    const json = await conexao.json();
    if(json.nome === "Informe seu nome"){
        alert('Reserva não efetuada. Informe seu nome!');
    }else if(json.cpf === "CPF inválido"){
        alert('Reserva não efetuada. CPF inválido!');
    }else if(json.email === "E-mail inválido"){
        alert('Reserva não efetuada. E-mail inválido!');
    }else{
        alert('Reserva cadastrada com sucesso!');
    }
    console.log(json.cpf);
}

document.addEventListener('DOMContentLoaded', function () {
    const form = document.querySelector(".formulario");
    form.addEventListener('submit', async function (event) {
        event.preventDefault();
        const nome = document.querySelector(".nome").value;
        const cpf = document.querySelector(".cpf").value;
        const email = document.querySelector(".email").value;
        const data = document.querySelector(".data").value;
        const mesa = document.querySelector(".mesa").value;
        await conectarApiReservaPost(nome, cpf, email, data, mesa);
        window.location.reload(true);
    });
});