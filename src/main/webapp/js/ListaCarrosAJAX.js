var xmlHttp;

function apresenta(selCidade){
    alert("Selecionado: " + selCidade.target.value);
}

function getCarros() {
    var cidade = document.getElementById("carro");
    var modelo = carro.value;
    console.log("modelo :{"+modelo+"}");
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

        var table = document.createElement("table");
        table.border = "1";
        table.style.border = "1px solid black";
        table.style.width = "400px";

        // CRIA LINHA TABELA (LINHA CABECALHO).

        var tr = table.insertRow(-1);

        // CRIA COLUNA NA LINHA DE CABECALHO
        var thSel = document.createElement('th');
        thSel.innerHTML = '';
        thSel.style.width = "10%";
        tr.appendChild(thSel);

        // CRIA COLUNA NA LINHA DE CABECALHO
        var thNome = document.createElement('th');
        thNome.innerHTML = 'Nome';
        thNome.style.width = "70%";
        tr.appendChild(thNome);

        // CRIA COLUNA NA LINHA DE CABECALHO
        var thEstado = document.createElement('th');
        thEstado.innerHTML = 'Estado';
        thEstado.style.width = "20%";
        tr.appendChild(thEstado);

        // CRIA DEMAIS LINHAS COM OS VALORES

        for (var i = 0; i < carros.length; i++) {

            // CRIA NOVA LINHA
            tr = table.insertRow(-1);
            //TODO FAZER O PARSING
            var tmp = carros[i];
            var indice = tmp.indexOf("/");
            var carro = tmp.slice(0, indice);
            var estado = tmp.slice(indice + 1);

            // CRIA COLUNA 1 NA LINHA

            var col1 = tr.insertCell(-1);


            // col1.style = "text-align:center"; analogo ao comando abaixo
            col1.style.textAlign = "center";

            // CRIA COLUNA 2 NA LINHA

            var col2 = tr.insertCell(-1);
            col2.innerHTML = carro;

            // CRIA COLUNA 3 NA LINHA

            var col3 = tr.insertCell(-1);
            // col3.style = "text-align:center"; analogo ao comando abaixo
            col3.style.textAlign = "center";
            col3.innerHTML = estado;
        }

        var divContainer = document.getElementById("carros");
        divContainer.innerHTML = "";

        // CRIA UM PARAGRAFO (TAG P) COM A QUANTIDADE DE CIDADES

        var p = document.createElement('p');
        p.innerHTML = 'Quantidade: ' + carros.length;

        // ADICIONA O PARAGRAFO AO CONTAINER.
        divContainer.appendChild(p);

        // ADICIONA A NOVA TABELA AO CONTAINER.
        divContainer.appendChild(table);
    }
}