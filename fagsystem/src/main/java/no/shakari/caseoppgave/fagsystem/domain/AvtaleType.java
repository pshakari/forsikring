package no.shakari.caseoppgave.fagsystem.domain;

public enum AvtaleType {
    HUS(1),
    INNBO(2),
    BIL(3),
    REISE(4),
    HELSE(5);

    private int value;

    AvtaleType(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
