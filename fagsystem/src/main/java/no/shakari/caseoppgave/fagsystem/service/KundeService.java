package no.shakari.caseoppgave.fagsystem.service;

import no.shakari.caseoppgave.fagsystem.domain.Kunde;
import org.springframework.stereotype.Service;

@Service
public interface KundeService {
    Kunde opprett(Kunde kunde);
}
