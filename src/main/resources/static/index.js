$(function () {
    hentAlle();
});

function reg() {
    //innhenting av verdier. Oppretter objekt og legger inn i Array.

    const billett = {
        fornavn: $("#fornavn").val(),
        etternavn: $("#etternavn").val(),
        telefonnr: $("#telefonnr").val(),
        epost: $("#epost").val(),
        antall: $("#antall").val(),
        film: $("#film").val()
    };

    const feil = sjekkInput();
    if (!feil) {
        $.post("/lagre", billett, function () {
            hentAlle();
        });

        $("#fornavn").val("");
        $("#etternavn").val("");
        $("#telefonnr").val("");
        $("#epost").val("");
        $("#antall").val("");
        $('#film').get(0).selectedIndex = 0;
    }
}

function hentAlle() {
    $.get("/hentAlle", function (billetter) {
        formaterData(billetter);
    });
}

//utskrift av registeret

function formaterData(billetter) {
    let ut = "<table><tr><th>Film</th><th>Antall</th>";
    ut += "<th>Fornavn</th><th>Etternavn</th><th>Telefonnr</th><th>Epost</th></tr>";

    for (let b of billetter) {
        ut += "<tr><td>" + b.film + "</td><td>" + b.antall;
        ut += "<td>" + b.fornavn + "</td><td>" + b.etternavn + "</td><td>" + b.telefonnr + "</td><td>" + b.epost;
        ut += "</td></tr>";
    }

    $("#billettene").html(ut);
}

//tømmer arrayet

function slettAlle() {
    billettReg = [];
    $.get("/slettAlle", function () {
        hentAlle();
    });
}

//validerer inputene ved å sjekke om det er skrevet noe i alle felt. Feilmelding dersom dette ikke stemmer.

function sjekkInput() {
    $("#fornavnFeil").html("");
    $("#etternavnFeil").html("");
    $("#telefonnrFeil").html("");
    $("#epostFeil").html("");
    $("#antallFeil").html("");

    let feil = false;
    if ($("#fornavn").val() === "") {
        $("#fornavnFeil").html("Fornavnet må oppgis");
        feil = true;
    }
    if ($("#etternavn").val() === "") {
        $("#etternavnFeil").html("Etternavnet må oppgis");
        feil = true;
    }
    if ($("#telefonnr").val() === "") {
        $("#telefonnrFeil").html("Telefonnr må oppgis");
        feil = true;
    }
    if ($("#epost").val() === "") {
        $("#epostFeil").html("Eposten må oppgis");
        feil = true;
    }
    if ($("#antall").val() === "") {
        $("#antallFeil").html("Antallet må oppgis");
        feil = true;
    }
    return feil;
}
