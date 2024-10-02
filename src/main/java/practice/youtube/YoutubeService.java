package practice.youtube;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class YoutubeService {
    @Value("${youtube.api.key}")
    private String apiKey;

    public void saveYoutube1() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.googleapis.com/youtube/v3/search?part=snippet&maxResults=10&q=" + "[검색어]&" +
                "key=" + apiKey;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        String resBody = response.getBody();

    }


}
