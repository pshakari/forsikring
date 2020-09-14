package no.shakari.caseoppgave.integrasjon.controller;

import no.shakari.caseoppgave.brevtjeneste.domain.Brev;
import no.shakari.caseoppgave.brevtjeneste.service.BrevService;
import no.shakari.caseoppgave.fagsystem.domain.Avtale;
import no.shakari.caseoppgave.fagsystem.domain.AvtaleStatus;
import no.shakari.caseoppgave.fagsystem.domain.Kunde;
import no.shakari.caseoppgave.integrasjon.mapper.Mapper;
import no.shakari.caseoppgave.integrasjon.service.IntegrasjonService;
import no.shakari.caseoppgave.integrasjon.vo.AvtaleFormVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Component
@Path("/integrasjon")
public class AvtaleController {
    private static final Logger LOG = LoggerFactory.getLogger(AvtaleController.class);

    @Autowired
    private IntegrasjonService integrasjonService;

    @Autowired
    private BrevService brevService;

    public AvtaleController(){}

    @GET
    @Path("/")
    public String hei() {
        return "Heisann!!";
    }

    @POST
    @Path("/v1/opprett")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String opprettAvtale(AvtaleFormVo avtaleForm) throws ExecutionException, InterruptedException {
        Kunde kundeMappet = Mapper.toKunde(avtaleForm);
        Avtale avtaleMappet = Mapper.toAvtale(avtaleForm);

        kundeMappet.getAvtaler().add(avtaleMappet);
        avtaleMappet.setKunde(kundeMappet);

        Future<Kunde> kunde = null;
        Future<Avtale> avtale = null;

        try {
            kunde = opprettKunde(kundeMappet);
            avtale = lagreAvtale(avtaleMappet);

            //vent til alt er lagret
            while (!(kunde.isDone() && avtale.isDone())) {
                Thread.sleep(20);
            }

        } catch (InterruptedException e) {
            LOG.error("Noe gikk galt under oppretting av kunde/avtale: ", e.getMessage());
            e.printStackTrace();
        }



        if(avtale != null && kunde != null) {
            Brev brev = createBrev(avtale.get(), kunde.get());
            Brev sendt= brevService.send(brev);
            if(sendt != null) {
                avtale.get().setStatus(AvtaleStatus.SENDT);
                integrasjonService.lagreAvtale(avtale.get());
            }


        }


        return "Opprettet avtale: "+avtale.get().getAvtaleId() + " status: "+ avtale.get().getStatus().toString();
    }

    @Async
    private Future<Kunde> opprettKunde(Kunde kunde) throws InterruptedException {
        Kunde results = integrasjonService.opprettKunde(kunde);
        // Artificial delay of 2s for demonstration purposes
        Thread.sleep(2000L);
        return new AsyncResult<Kunde>(results);
    }

    @Async
    private Future<Avtale> lagreAvtale(Avtale avtale) throws InterruptedException {
        Avtale results = integrasjonService.lagreAvtale(avtale);
        // Artificial delay of 2s for demonstration purposes
        Thread.sleep(1000L);
        return new AsyncResult<Avtale>(results);
    }

    private Brev createBrev(Avtale avtale, Kunde kunde) {
        Brev brev = new Brev();
        brev.setNavn(kunde.getFornavn()+" "+kunde.getEtternavn());
        //etc
        brev.setStatus(avtale.getStatus().toString());

        return brev;
    }

}
