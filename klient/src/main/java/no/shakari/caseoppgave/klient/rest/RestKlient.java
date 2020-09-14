package no.shakari.caseoppgave.klient.rest;
import no.shakari.caseoppgave.integrasjon.vo.AvtaleFormVo;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class RestKlient {
    static final String postUrl = "http://localhost:8080/integrasjon/v1/opprett";

    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(postUrl);
        String response = target.request(MediaType.APPLICATION_JSON)
                .accept(MediaType.TEXT_PLAIN_TYPE)
                .post(Entity.json(create()), String.class);

        System.out.println(response);
    }

    static AvtaleFormVo create() {
        AvtaleFormVo avtaleFormVo = new AvtaleFormVo();
        avtaleFormVo.setFornavn("fornavn");
        avtaleFormVo.setEtternavn("etternavn");
        avtaleFormVo.setEpost("fornavn@etternavn.no");
        avtaleFormVo.setTlf("12345");
        avtaleFormVo.setAvtale("BIL");

        return avtaleFormVo;
    }


}
