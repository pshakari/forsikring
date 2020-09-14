package no.shakari.caseoppgave.fagsystem.service;

import no.shakari.caseoppgave.fagsystem.domain.Avtale;
import no.shakari.caseoppgave.fagsystem.domain.AvtaleStatus;
import org.springframework.stereotype.Service;

@Service
public interface AvtaleService {
    Avtale lagre(Avtale avtale);
}
