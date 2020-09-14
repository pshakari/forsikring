package no.shakari.caseoppgave.fagsystem.repo;

import no.shakari.caseoppgave.fagsystem.domain.Kunde;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface KundeRepo extends CrudRepository<Kunde, Long> {
}
