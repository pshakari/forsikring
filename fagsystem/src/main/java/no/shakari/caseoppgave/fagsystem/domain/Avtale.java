package no.shakari.caseoppgave.fagsystem.domain;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
public class Avtale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="avtale_id")
    private Long avtaleId;

    private AvtaleType type;
    private AvtaleStatus status;
    private LocalDate gyldigFra;
    private LocalDate gyldigTil;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "kunde_id", updatable = true, insertable = true, nullable = false)
    private Kunde kunde;

    public Long getAvtaleId() {
        return avtaleId;
    }

    public void setAvtaleId(Long avtaleId) {
        this.avtaleId = avtaleId;
    }

    public AvtaleType getType() {
        return type;
    }

    public void setType(AvtaleType type) {
        this.type = type;
    }

    public AvtaleStatus getStatus() {
        return status;
    }

    public void setStatus(AvtaleStatus status) {
        this.status = status;
    }

    public LocalDate getGyldigFra() {
        return gyldigFra;
    }

    public void setGyldigFra(LocalDate gyldigFra) {
        this.gyldigFra = gyldigFra;
    }

    public LocalDate getGyldigTil() {
        return gyldigTil;
    }

    public void setGyldigTil(LocalDate gyldigTil) {
        this.gyldigTil = gyldigTil;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }
}
