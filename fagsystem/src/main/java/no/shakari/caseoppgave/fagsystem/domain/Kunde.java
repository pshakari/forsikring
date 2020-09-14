package no.shakari.caseoppgave.fagsystem.domain;


import java.util.List;
import javax.persistence.*;

@Entity
public class Kunde {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="kunde_id")
    private Long kundeId;

    private String fornavn;
    private String etternavn;
    private String epost;
    private String tlf;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "kunde")
    private List<Avtale> avtaler;

    public Long getKundeId() {
        return kundeId;
    }

    public void setKundeId(Long kundeId) {
        this.kundeId = kundeId;
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

    public List<Avtale> getAvtaler() {
        return avtaler;
    }

    public void setAvtaler(List<Avtale> avtaler) {
        this.avtaler = avtaler;
    }
}
