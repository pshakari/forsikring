package no.shakari.caseoppgave.integrasjon.service;

import no.shakari.caseoppgave.fagsystem.domain.Avtale;
import no.shakari.caseoppgave.fagsystem.domain.Kunde;
import org.springframework.stereotype.Service;

@Service
public interface IntegrasjonService {
    Kunde opprettKunde(Kunde kunde);
    Avtale lagreAvtale(Avtale avtale);

}
