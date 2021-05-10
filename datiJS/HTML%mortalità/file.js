function Calcola(){
    var ageGroup = document.getElementsByName("ageGroup")
    var age = 0;
    for(var i = 0; i < 5; i++){
        if(ageGroup[i].checked){
            age = ageGroup[i].value
        }
    }
    var iperTensione = document.getElementById("checkIpertensione").checked
    var respirazione = document.getElementById("checkRespiratori").checked
    var diabete = document.getElementById("checkDiabete").checked
    var cardio = document.getElementById("checkCardio").checked
    var percentuale = 0

    //percentuale età
    if(age == 0){
        percentuale = 20
    }
    else if(age == 1){
        percentuale = 30
    }
    else if(age == 2){
        percentuale = 50
    }
    else if(age == 3){
        percentuale = 500
    }
    else{
        percentuale = 1480
    }

    //percentuale genere
    if(document.getElementById("radioMaschio").checked){
        percentuale += 15
    }
    else{
        percentuale += 4
    }

    //percentuale controlli malattie
    //add code

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