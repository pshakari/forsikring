package controller;

import no.shakari.caseoppgave.integrasjon.IntegrasjonApp;
import no.shakari.caseoppgave.integrasjon.vo.AvtaleFormVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.net.URISyntaxException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = IntegrasjonApp.class)
public class AvtaleControllerInt {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testMe() throws URISyntaxException {
        final String baseUrl = "http://localhost:"+8080+"/integrasjon/v1/opprett";
        URI uri = new URI(baseUrl);

        AvtaleFormVo avtaleFormVo = new AvtaleFormVo();
        avtaleFormVo.setFornavn("Hallo");
        avtaleFormVo.setEtternavn("Test");
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<AvtaleFormVo> request = new HttpEntity<>(avtaleFormVo, headers);

        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
        System.out.println("RESPONSE: "+request);
    }
}
