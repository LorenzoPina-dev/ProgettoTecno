function loadDatiReg() {
    $.ajax({
        url: 'https://raw.githubusercontent.com/LorenzoPina-dev/ProgettoTecno/codice/dati.csv',
        success: function (data) {
            splitDatiReg(data);
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

function loadDatiNaz() {
    $.ajax({
        url: 'https://raw.githubusercontent.com/LorenzoPina-dev/ProgettoTecno/codice/datiNaz.csv',
        success: function (data) {
            splitDatiNaz(data);
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