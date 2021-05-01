function loadDati() {
    $.ajax({
        url: 'https://raw.githubusercontent.com/LorenzoPina-dev/ProgettoTecno/codice/datiNaz.csv',
        success: function (data) {
            splitDati(data);
        }
    });
}

function splitDati(data) {
    let k = 0;
    let righe = data.split("\n");
    let intestazione = righe[0].split(";");
    let dati = righe[1].split(";");

    let datiNaz = new Object();
    for (let i = 0; i < intestazione.length; i++) {
        datiNaz[intestazione[i]] = dati[i];
    }


}