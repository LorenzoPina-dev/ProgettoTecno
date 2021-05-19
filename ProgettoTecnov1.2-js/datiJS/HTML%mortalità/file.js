function Calcola() {
    let a = "";
    var percentualeTotale = 0;

    var ageGroup = document.getElementsByName("ageGroup")
    for (var i = 0; i < 5; i++) {
        if (ageGroup[i].checked) {
            percentualeTotale += parseFloat(ageGroup[i].value);
        }
    }
    if (document.getElementsByName("sexGroup")[0].checked) {
        percentualeTotale += parseFloat(document.getElementsByName("sexGroup")[0].value);
    }
    else if (document.getElementsByName("sexGroup")[1].checked) {
        percentualeTotale += parseFloat(document.getElementsByName("sexGroup")[1].value);
    }
    let cancro = document.getElementById("checkCancro");
    let iperTensione = document.getElementById("checkIpertensione");
    let respirazione = document.getElementById("checkRespiratori");
    let diabete = document.getElementById("checkDiabete");
    let cardio = document.getElementById("checkCardio");
    let percentualeTemp = 0;
    let conta = 0;

    if (cancro.checked){
        percentualeTemp += parseFloat(cancro.value);
        conta++;
    }
    if (iperTensione.checked){
        percentualeTemp += parseFloat(iperTensione.value);
        conta++;
    }
    if (respirazione.checked){
        percentualeTemp += parseFloat(respirazione.value);
        conta++;
    }
    if (diabete.checked){
        percentualeTemp += parseFloat(diabete.value);
        conta++;
    }
    if (cardio.checked){
        percentualeTemp += parseFloat(cardio.value);
        conta++;
    }

    if (percentualeTemp > 0) {
        percentualeTotale *= percentualeTemp;
    }
    
    if (percentualeTotale >= 92) {
        percentualeTotale = 92;
    }

    percentualeTotale *= 100;
    percentualeTotale = Math.floor(percentualeTotale);



    a = "Rischio mortalità del " + percentualeTotale / 100 + "%";

    if (percentualeTotale / 100 > 19.99) {
        document.getElementById("divRisultato").innerHTML = '<div class="classeRisultatoSopra20"><p class="p2">' + a + '</p></div>';
    }
    else if (percentualeTotale / 100 > 4.99) {
        document.getElementById("divRisultato").innerHTML = '<div class="classeRisultatoSopra5"><p class="p2">' + a + '</p></div>';
    } else {
        document.getElementById("divRisultato").innerHTML = '<div class="classeRisultatoSotto5"><p class="p2">' + a + '</p></div>';
    }
}
