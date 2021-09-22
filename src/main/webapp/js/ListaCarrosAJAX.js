var xmlHttp;

function apresenta(selCidade){
    alert("Selecionado: " + selCidade.target.value);
}

function getCarros() {
    var cidade = document.getElementById("carro");
    var modelo = carro.value;
    if (typeof XMLHttpRequest !== "undefined") {
        xmlHttp = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    if (xmlHttp === null) {
        alert("Browser does not support XMLHTTP Request");
        return;
    }

    var url = "results";
    url += "?term=" + modelo;
    xmlHttp.onreadystatechange = atualizaTabelaCarros;
    xmlHttp.open("GET", url, true);
    xmlHttp.send(null);

}

function atualizaTabelaCarros() {
    if (xmlHttp.readyState === 4 || xmlHttp.readyState === "complete") {
        var carros = JSON.parse(xmlHttp.responseText);

        // CRIA UMA TABELA DINAMICA
        var sessionVar = document.getElementById('propor').value;
        console.log("propor "+ sessionVar);
        var oldtbody = document.getElementById("tbody");
        var table = document.createElement("tbody");
        table.setAttribute("id", "tbody");
        // var table = document.createElement("table");
        table.border = "1";
        table.style.border = "1px solid black";
        table.style.width = "400px";

        // // CRIA LINHA TABELA (LINHA CABECALHO).
        //
        // var tr = table.insertRow(-1);
        //
        //
        // // CRIA COLUNA NA LINHA DE CABECALHO
        // var thModelo = document.createElement('th');
        // thModelo.innerHTML = 'Modelo';
        // thModelo.style.width = "70%";
        // tr.appendChild(thModelo);
        //
        // // CRIA COLUNA NA LINHA DE CABECALHO
        // var thPlaca = document.createElement('th');
        // thPlaca.innerHTML = 'Placa';
        // thPlaca.style.width = "70%";
        // tr.appendChild(thPlaca);
        //
        // // CRIA COLUNA NA LINHA DE CABECALHO
        // var thChassi = document.createElement('th');
        // thChassi.innerHTML = 'Chassi';
        // thChassi.style.width = "70%";
        // tr.appendChild(thChassi);
        //
        // // CRIA COLUNA NA LINHA DE CABECALHO
        // var thDescricao = document.createElement('th');
        // thDescricao.innerHTML = 'Descricao';
        // thDescricao.style.width = "70%";
        // tr.appendChild(thDescricao);
        //
        // // CRIA COLUNA NA LINHA DE CABECALHO
        // var thAno = document.createElement('th');
        // thAno.innerHTML = 'Ano';
        // thAno.style.width = "70%";
        // tr.appendChild(thAno);
        //
        // // CRIA COLUNA NA LINHA DE CABECALHO
        // var thKm = document.createElement('th');
        // thKm.innerHTML = 'Km';
        // thKm.style.width = "70%";
        // tr.appendChild(thKm);
        //
        //
        // // CRIA COLUNA NA LINHA DE CABECALHO
        // var thValor = document.createElement('th');
        // thValor.innerHTML = 'Valor';
        // thValor.style.width = "70%";
        // tr.appendChild(thValor);


        // CRIA DEMAIS LINHAS COM OS VALORES

        for (var i = 0; i < carros.length; i++) {

            // CRIA NOVA LINHA
            tr = table.insertRow(-1);
            var tmp = carros[i];
            var lista = tmp.split(";");
            var id = lista[0];
            var modelo = lista[1];
            var cnpj = lista[2];
            var placa = lista[3];
            var chassi = lista[4];
            var descricao = lista[5];
            var ano = lista[6];
            var km = lista[7];
            var valor = lista[8];






            var carro = lista[0];
            var estado = lista[1];




            var col2 = tr.insertCell(-1);
            col2.style.textAlign = "center";
            col2.innerHTML = modelo;

            var col3 = tr.insertCell(-1);
            col3.style.textAlign = "center";
            col3.innerHTML = placa;

            var col4 = tr.insertCell(-1);
            col4.style.textAlign = "center";
            col4.innerHTML = chassi;

            var col5 = tr.insertCell(-1);
            col5.style.textAlign = "center";
            col5.innerHTML = descricao;

            var col6 = tr.insertCell(-1);
            col6.style.textAlign = "center";
            col6.innerHTML = ano;

            var col7 = tr.insertCell(-1);
            col7.style.textAlign = "center";
            col7.innerHTML = km;

            var col8 = tr.insertCell(-1);
            col8.style.textAlign = "center";
            col8.innerHTML = valor;
        }


        // CRIA UM PARAGRAFO (TAG P) COM A QUANTIDADE DE CIDADES

        var p = document.getElementById('qtd');
        p.innerHTML = carros.length;


        oldtbody.parentNode.replaceChild(table,oldtbody);
    }
}