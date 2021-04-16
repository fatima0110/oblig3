package oblig3;

public class Kinobilletter {
    private String fornavn;
    private String etternavn;
    private String telefonnr;
    private String epost;
    private String antall;
    private String film;

    public Kinobilletter(String fornavn, String etternavn, String telefonnr,
                         String epost, String antall, String film) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.telefonnr = telefonnr;
        this.epost = epost;
        this.antall = antall;
        this.film = film;
    }
    public Kinobilletter() {
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }
    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public String getTelefonnr() {
        return telefonnr;
    }

    public void setTelefonnr(String telefonnr) {
        this.telefonnr = telefonnr;
    }

    public String getEpost() {
        return epost;
    }

    public void setEpost(String epost) {
        this.epost = epost;
    }

    public String getAntall() {
        return antall;
    }

    public void setAntall(String antall) {
        this.antall = antall;

    }

    public String getFilm() {
        return film;

    }

    public void setFilm(String film) {
        this.film = film;
    }


}
