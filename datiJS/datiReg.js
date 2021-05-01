function loadDati() {
    $.ajax({
        url: 'https://raw.githubusercontent.com/LorenzoPina-dev/ProgettoTecno/codice/dati.csv',
        success: function (data) {
            splitDati(data);
        }
    });
}

function splitDati(data) {
    let k = 0;
    let righe = data.split("\n");
    let regioni = []; //vettore per le regioni

    let intestazione = righe[0].split(";");
    for (let i = 1; i < righe.length - 1; i++) {
        let campi = righe[i].split(";");
        regioni[k] = new Object();
        for (let j = 0; j < campi.length; j++)
            regioni[k][intestazione[j]] = campi[j];
        k++;
    }
}