package no.shakari.caseoppgave.brevtjeneste.domain;

public class Brev {
    private String navn;
    private String adresse;
    private String tlf;
    private String avtale;
    private String status;

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public String getAvtale() {
        return avtale;
    }

    public void setAvtale(String avtale) {
        this.avtale = avtale;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
