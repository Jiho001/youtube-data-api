package practice.youtube;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

@Configuration
public class MyConfiguration {

    @Bean
    public RestClient restClient() {
        return RestClient.create();
    }
}
