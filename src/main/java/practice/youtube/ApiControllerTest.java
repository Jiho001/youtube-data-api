package practice.youtube;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@Slf4j
public class ApiControllerTest {
    RestClient restClient = RestClient.create();


    @GetMapping("/test")
    public void callAPI() {
        int id = 1;
        ResponseEntity<String> result = restClient.get()
                .uri("https://jsonplaceholder.typicode.com/posts/{id}", id)
                .retrieve()
                .toEntity(String.class);  // 응답을 ResponseEntity로 변환하고, 응답의 본문을 String으로 받음

        log.info("result: {}", result);
        log.info("Response status: {}", result.getStatusCode());
        log.info("Response headers: {}", result.getHeaders());
        log.info("Contents: {}", result.getBody());
    }



}
