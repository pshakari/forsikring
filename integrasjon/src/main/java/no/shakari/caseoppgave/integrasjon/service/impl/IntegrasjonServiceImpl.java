package no.shakari.caseoppgave.integrasjon.service.impl;

import no.shakari.caseoppgave.fagsystem.domain.Avtale;
import no.shakari.caseoppgave.fagsystem.domain.Kunde;
import no.shakari.caseoppgave.fagsystem.service.AvtaleService;
import no.shakari.caseoppgave.fagsystem.service.KundeService;
import no.shakari.caseoppgave.integrasjon.service.IntegrasjonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IntegrasjonServiceImpl implements IntegrasjonService {

    @Autowired
    private KundeService kundeService;

    @Autowired
    private AvtaleService avtaleService;

    @Override
    public Kunde opprettKunde(Kunde kunde) {
        return kundeService.opprett(kunde);
    }

    @Override
    public Avtale lagreAvtale(Avtale avtale) {
        return avtaleService.lagre(avtale);
    }
}
