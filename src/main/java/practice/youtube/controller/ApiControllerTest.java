package practice.youtube.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import practice.youtube.domain.Essay;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@RestController
@Slf4j
public class ApiControllerTest {
    RestClient restClient = RestClient.create();


    /**
     * 응답을 ResponseEntity 로 변환하여 받기
     * .retrieve()로 응답받은 것을
     * .toEntity(String.class) 메소드로 ResponseEntity 객체로 변환.
     * 이때 파라미터인 String.class 의 의미는 ResponseEntity 객체의 바디를 String 타입으로 하겠다는 것
     */
    @GetMapping("/test1")
    public void callAPI1() {
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

    
    /**
     * 응답을 클래스 인스턴스로 변환하여 받기
     */
    @GetMapping("/test2/{id}")
    public void callAPI2(@PathVariable long id) {
        Essay essay = restClient.get()
                .uri("https://jsonplaceholder.typicode.com/posts/{id}", id)
                .accept(APPLICATION_JSON)
                .retrieve()
                .body(Essay.class);

        log.info("essay.userId: {}", essay.getUserId());
        log.info("essay.id: {}", essay.getId());
        log.info("essay.title: {}", essay.getTitle());
        log.info("essay.body: {}", essay.getBody());

    }



}
