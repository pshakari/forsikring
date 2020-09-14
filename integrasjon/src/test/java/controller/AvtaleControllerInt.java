package controller;

import no.shakari.caseoppgave.integrasjon.vo.AvtaleFormVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.net.URISyntaxException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AvtaleControllerInt {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testMe() throws URISyntaxException {
        final String baseUrl = "http://localhost:"+8080+"/integrasjon/v1/opprett";
        URI uri = new URI(baseUrl);
        /*HttpEntity<AvtaleFormVo> request = new HttpEntity<>(new AvtaleFormVo());


        String entity = restTemplate
                .postForObject("http://localhost:" + 8080 + "/integrasjon/v1/opprett", request, String.class);

                //restTemplate.getForEntity("http://localhost:8080/integration", String.class);
        System.out.println(": "+entity);
*/
        //String patchInJson = "{\"fornavn\":\"ultraman\", \"etternavn\":\"etternavn\"}";

        AvtaleFormVo avtaleFormVo = new AvtaleFormVo();
        avtaleFormVo.setFornavn("Hallo");
        avtaleFormVo.setEtternavn("Test");
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");

        HttpEntity<AvtaleFormVo> request = new HttpEntity<>(avtaleFormVo, headers);

        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
        System.out.println("RESPONSE: "+request);


        //assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);

       /* ResponseEntity<String> entity = this.restTemplate.getForEntity("/hello",
                String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(entity.getBody()).isEqualTo("Hello from Spring");*/
    }
}
