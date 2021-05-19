function loadDatiReg() {
    $.ajax({
        url: 'https://raw.githubusercontent.com/LorenzoPina-dev/ProgettoTecno/codice/dati.csv',
        success: function (data) {
            datiReg = splitDatiReg(data);
            console.log(datiReg);
            loadTableReg("tableReg", datiReg);
        }
    });
}

function splitDatiReg(data) {
    let k = 0;
    let righe = data.split("\n");
    let regioni = []; //vettore per le regioni

    let intestazione = righe[0].split(";");
    for (let i = 1; i < righe.length - 1; i++) {
        let campi = righe[i].split(";");
        regioni[campi[0]] = new Object();
        for (let j = 0; j < campi.length; j++)
            regioni[campi[0]][intestazione[j]] = campi[j];
        k++;
    }
    return regioni;
}
let temp = [];
function loadDatiNaz() {
    $.ajax({
        url: 'https://raw.githubusercontent.com/LorenzoPina-dev/ProgettoTecno/codice/datiNaz.csv',
        success: function (data) {
            temp = splitDatiNaz(data);
            console.log(temp);
            loadHead("tableNaz", "body2", temp);
        }
    });
}

function splitDatiNaz(data) {
    let righe = data.split("\n");
    let intestazione = righe[0].split(";");
    let dati = righe[1].split(";");

    let datiNaz = new Object();
    for (let i = 0; i < intestazione.length; i++) {
        datiNaz[intestazione[i]] = dati[i];
    }
    return datiNaz;
}

function loadHead(id, nomeBody, v) {
    html = "";
    html += "<thead>";
    for (key in v) {
        html += "<th >" + key + "</th>";
    }
    html += "</thead>";
    html += "<tbody id='" + nomeBody + "'>" + "</tbody>";
    document.getElementById(id).innerHTML = html;
    loadBody(nomeBody, v);
}

function loadBody(id, v) {
    html = "";
    html += "<tr>";
    for (key in v) {
        html += "<td>" + v[key] + "</td>";
    }
    html += "</tr>";
    document.getElementById(id).innerHTML = html;
}

function loadTableReg(id, data) {
    html = "";
    html += "<thead>";
    for (key in data) {
        for (k in data[key]) {
            html += "<th>" + k + "</th>";
        }
        break;
    }
    html += "</thead>";
    html += "<tbody>";
    for (key in data) {
        html += "<tr>"
        for (k in data[key])
            html += "<td>" + data[key][k] + "</td>"
        html += "</tr>"
    }

    html += "</tbody>"
    document.getElementById(id).innerHTML = html;
    loadSideBar(data)
}

function loadSideBar(data) {
    html = "";
    for (key in data) {
        html += "<li class='nav-item' id='colore'>";
        html += "<button class='nav-link active button fontSize' aria-current='page' onclick='loadDatiProv(" + '"' + key.replace(/'/g, "") + '"' + ")'>"
        html += "<span data-feather='" + key + "'></span>"
        html += key
        html += " </button>"
        html += "</li>"
    }
    document.getElementById("sideBarReg").innerHTML = html;
}


function loadDatiProv(regione) {
    $.ajax({
        url: 'https://raw.githubusercontent.com/LorenzoPina-dev/ProgettoTecno/codice/datiProv.csv',
        success: function (data) {
            temp = splitDatiProv(data);
            console.log(temp);
            loadProvincie(regione, temp);
        }
    });
}

function splitDatiProv(data) {
    let k = 0;
    let righe = data.split("\n");
    let intestazione = righe[0].split(";");
    let province = []; //vettore per le province
    for (let i = 1; i < righe.length - 1; i++) {
        let campi = righe[i].split(";");
        province[campi[2]] = new Object();
    }
    for (let j = 1; j < righe.length - 1; j++) {
        let campi = righe[j].split(";");
        province[campi[2]][campi[0]] = new Object();
        province[campi[2]][campi[0]][intestazione[1]] = campi[1];
    }
    return province;
}

function loadProvincie(regione, data) {
    html = "";
    document.getElementById("delete").innerHTML = html;

    for (key in data) {
        console.log(key);
        if (key.replace(/'/g, "") === regione) {
            html += "<div class='center colore fontSize'>" + regione + "</div>";
            html += "<img class='center' src='img/" + regione + ".jpg'>" + "<br>";
            html += "<div class='row'>" + "<div class='col-sm-12 cella center colore fontSize'>" + "TOTALE CASI" + "</div>" + "</div>"
            for (k in data[key]) {
                html += "<div class='row colore fontSize'>" + "<div class='col-sm-4 cella'>" + k + "</div>" + "<div class='col-sm-8 cella center'>" + data[key][k].totale_casi + "</div>" + "</div>"
            }
        }
    }

    document.getElementById("Datiprovincie").innerHTML = html;
}