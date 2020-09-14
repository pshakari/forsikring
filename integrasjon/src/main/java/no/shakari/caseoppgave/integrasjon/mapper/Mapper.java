package no.shakari.caseoppgave.integrasjon.mapper;

import no.shakari.caseoppgave.fagsystem.domain.Avtale;
import no.shakari.caseoppgave.fagsystem.domain.AvtaleStatus;
import no.shakari.caseoppgave.fagsystem.domain.AvtaleType;
import no.shakari.caseoppgave.fagsystem.domain.Kunde;
import no.shakari.caseoppgave.integrasjon.vo.AvtaleFormVo;

import java.time.LocalDate;

public class Mapper {
    public static Kunde toKunde(AvtaleFormVo avtaleFormVo){
        Kunde kunde = new Kunde();
        kunde.setFornavn(avtaleFormVo.getFornavn());
        //etc
        return kunde;
    }

    public static Avtale toAvtale(AvtaleFormVo avtaleFormVo) {
        Avtale avtale = new Avtale();
        avtale.setGyldigFra(LocalDate.now());
        avtale.setStatus(AvtaleStatus.NY);
        avtale.setType(AvtaleType.BIL);
        return avtale;
    }
}
