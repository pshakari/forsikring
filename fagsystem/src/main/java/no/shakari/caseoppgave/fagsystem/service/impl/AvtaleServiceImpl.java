package no.shakari.caseoppgave.fagsystem.service.impl;

import no.shakari.caseoppgave.fagsystem.domain.Avtale;
import no.shakari.caseoppgave.fagsystem.repo.AvtaleRepo;
import no.shakari.caseoppgave.fagsystem.service.AvtaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvtaleServiceImpl implements AvtaleService {
    @Autowired
    private AvtaleRepo avtaleRepo;

    @Override
    public Avtale lagre(Avtale avtale) {
        return avtaleRepo.save(avtale);
    }
}
