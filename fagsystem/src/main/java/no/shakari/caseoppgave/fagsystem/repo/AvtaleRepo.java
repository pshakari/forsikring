package no.shakari.caseoppgave.fagsystem.repo;

import no.shakari.caseoppgave.fagsystem.domain.Avtale;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvtaleRepo extends CrudRepository<Avtale, Long> {
}
