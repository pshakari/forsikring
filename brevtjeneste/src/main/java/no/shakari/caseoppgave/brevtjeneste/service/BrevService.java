package no.shakari.caseoppgave.brevtjeneste.service;

import no.shakari.caseoppgave.brevtjeneste.domain.Brev;
import org.springframework.stereotype.Service;

@Service
public class BrevService {
    public Brev send(Brev brev){
        //send brev
        brev.setStatus("SENDT");

        return brev;
    }

    public Brev betal(Brev brev) {
        brev.setStatus("PAY");

        return brev;
    }

    public Brev aktiver(Brev brev) {
        brev.setStatus("AKTIVERT");

        return brev;
    }
}
