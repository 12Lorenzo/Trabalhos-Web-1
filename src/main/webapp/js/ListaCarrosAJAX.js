var xmlHttp;

function apresenta(selCidade){
    alert("Selecionado: " + selCidade.target.value);
}

function getCarros(context) {
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
    xmlHttp.onreadystatechange = () => atualizaTabelaCarros(context);
    xmlHttp.open("GET", url, true);
    xmlHttp.send(null);

}

function atualizaTabelaCarros(context) {
    if (xmlHttp.readyState === 4 || xmlHttp.readyState === "complete") {
        var carros = JSON.parse(xmlHttp.responseText);

        // CRIA UMA TABELA DINAMICA
        var sessionVar = document.getElementById('propor').value;
        console.log("propor "+ sessionVar);
        var oldtbody = document.getElementById("tbody");
        var table = document.createElement("tbody");
        table.setAttribute("id", "tbody");

        table.border = "1";
        table.style.border = "1px solid black";
        table.style.width = "400px";


        // CRIA DEMAIS LINHAS COM OS VALORES

        for (var i = 0; i < carros.length; i++) {



            var tmp = carros[i];
            var lista = tmp.split(";");
            var id = lista[0];
            var modelo = lista[1];
            var images = table.insertRow(-1);
            var cellimg = images.insertCell(-1);
            cellimg.setAttribute("id", "image"+id);
            cellimg.setAttribute("colspan","7");
            tr = table.insertRow(-1);
            var cnpj = lista[2];
            var placa = lista[3];
            var chassi = lista[4];
            var descricao = lista[5];
            var ano = lista[6];
            var km = lista[7];
            var valor = lista[8];


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
            if (sessionVar !== "false") {
                var col9 = tr.insertCell(-1);
                col9.style.textAlign = "center";

                var a = document.createElement("a");
                a.setAttribute("href", context+"/proposta/"+id);
                a.innerHTML = "+";
                col9.appendChild(a);
            }
        }


        // Pega o span COM A QUANTIDADE DE CARROS

        var p = document.getElementById('qtd');
        p.innerHTML = carros.length;


        oldtbody.parentNode.replaceChild(table,oldtbody);
    }
}