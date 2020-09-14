package no.shakari.caseoppgave.integrasjon.vo;

import java.io.Serializable;

public class AvtaleFormVo implements Serializable {
    public AvtaleFormVo(){}

    private String fornavn;
    private String etternavn;
    private String epost;
    private String tlf;
    private String avtale;

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

    public String getEpost() {
        return epost;
    }

    public void setEpost(String epost) {
        this.epost = epost;
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
}
