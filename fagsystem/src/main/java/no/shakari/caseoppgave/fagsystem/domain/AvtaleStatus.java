package no.shakari.caseoppgave.fagsystem.domain;

public enum AvtaleStatus {
    NY(0),
    SENDT(1),
    TILBETALING(2),
    KANSELLERT(3),
    AKTIVERT(4),
    DEAKTIVERT(5);

    private int value;

    AvtaleStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
