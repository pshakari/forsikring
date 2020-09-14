package service;

import no.shakari.caseoppgave.fagsystem.domain.Kunde;
import no.shakari.caseoppgave.integrasjon.service.IntegrasjonService;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class IntegrasjonServiceTest {
    @Mock
    private IntegrasjonService integrasjonService;

    @Before
    public void setUp() {
        Kunde kunde = new Kunde();
        kunde.setKundeId(123L);
        when(integrasjonService.opprettKunde(any())).thenReturn(kunde);
    }


    @Test
    public void testAtOpprettKundeReturnererKundeNr(){
        Kunde faktisk = createKunde();

        Kunde forventet =  integrasjonService.opprettKunde(faktisk);

        Assertions.assertThat(faktisk.getKundeId()).isEqualTo(forventet.getKundeId());

    }

    private Kunde createKunde() {
        Kunde kunde = new Kunde();
        kunde.setFornavn("fornavn");
        kunde.setEtternavn("Etternavn");
        kunde.setKundeId(123L);

        return kunde;
    }
}
