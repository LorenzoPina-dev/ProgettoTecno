function Calcola(){
    var ageGroup = document.getElementsByName("ageGroup")
    var age = 0;
    for(var i = 0; i < 5; i++){
        if(ageGroup[i].checked){
            age = ageGroup[i].value
        }
    }
    var percentualeEta = 0
    var iperTensione = document.getElementById("checkIpertensione").checked
    var respirazione = document.getElementById("checkRespiratori").checked
    var diabete = document.getElementById("checkDiabete").checked
    var cardio = document.getElementById("checkCardio").checked
    var percentualeTotale = 0

    //percentuale età
    if(age == 0){
        percentualeEta = 20
    }
    else if(age == 1){
        percentualeEta = 30
    }
    else if(age == 2){
        percentualeEta = 50
    }
    else if(age == 3){
        percentualeEta = 500
    }
    else if(age == 4) {
        percentualeEta = 1480
    }

    //percentuale genere
    if(document.getElementById("radioMaschio").checked){
        percentualeEta += 15
    }
    else if (document.getElementById("radioFemmina").checked) {
        percentualeEta += 4
    }

    //percentuale controlli malattie
    if (cardio == true) {
        percentualeTotale += percentualeEta * 10.5
    }

    if (diabete == true) {
        percentualeTotale += percentualeEta *  7.3
    }

    if (respirazione == true) {
        percentualeTotale += percentualeEta * 6.3
    }
    
    if (iperTensione == true) {
        percentualeTotale += percentualeEta * 6
    }

    alert("rischio mortalità del " + percentuale / 100 + "%")
}

function Reset(){
    document.getElementById("radio19").checked = false;
    document.getElementById("radio39").checked = false;
    document.getElementById("radio59").checked = false;
    document.getElementById("radio79").checked = false;
    document.getElementById("radioOver").checked = false;
    document.getElementById("radioMaschio").checked = false;
    document.getElementById("radioFemmina").checked = false;
    document.getElementById("checkIpertensione").checked = false;
    document.getElementById("checkRespiratori").checked = false;
    document.getElementById("checkDiabete").checked = false;
    document.getElementById("checkCardio").checked = false;
}
