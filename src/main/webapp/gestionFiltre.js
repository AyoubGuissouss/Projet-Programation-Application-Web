function enable_FiltreNom(status){
    status=!status;
    document.formFiltres.nomCherche.disabled = status;
    document.getElementById("filtrePrix").checked = false;
    document.getElementById("filtreCategorie").checked = false;
    document.getElementById("choixPrix1").disabled = true;
    document.getElementById("choixPrix2").disabled = true;
    document.getElementById("choixPrix3").disabled = true;
    document.getElementById("choixCategorie1").disabled = true;
    document.getElementById("choixCategorie2").disabled = true;
    document.getElementById("choixCategorie3").disabled = true;

    document.getElementById("choixPrix1").checked = false;
    document.getElementById("choixPrix2").checked = false;
    document.getElementById("choixPrix3").checked = false;
    document.getElementById("choixCategorie1").checked = false;
    document.getElementById("choixCategorie2").checked = false;
    document.getElementById("choixCategorie3").checked = false;
}

function enable_FiltrePrix(status){
    status=!status;
    document.formFiltres.choixPrix1.disabled = status;
    document.formFiltres.choixPrix2.disabled = status;
    document.formFiltres.choixPrix3.disabled = status;
    document.getElementById("filtreNom").checked = false;
    document.getElementById("filtreCategorie").checked = false;
    document.getElementById("nomCherche").disabled = true;
    document.getElementById("choixCategorie1").disabled = true;
    document.getElementById("choixCategorie2").disabled = true;
    document.getElementById("choixCategorie3").disabled = true;

    document.getElementById("nomCherche").value = "";
    document.getElementById("choixCategorie1").checked = false;
    document.getElementById("choixCategorie2").checked = false;
    document.getElementById("choixCategorie3").checked = false;
}

function enable_FiltreCategorie(status){
    status=!status;
    document.formFiltres.choixCategorie1.disabled = status;
    document.formFiltres.choixCategorie2.disabled = status;
    document.formFiltres.choixCategorie3.disabled = status;
    document.getElementById("filtrePrix").checked = false;
    document.getElementById("filtreNom").checked = false;
    document.getElementById("nomCherche").disabled = true;
    document.getElementById("choixPrix1").disabled = true;
    document.getElementById("choixPrix2").disabled = true;
    document.getElementById("choixPrix3").disabled = true;

    document.getElementById("nomCherche").value = "";
    document.getElementById("choixPrix1").checked = false;
    document.getElementById("choixPrix2").checked = false;
    document.getElementById("choixPrix3").checked = false;
}