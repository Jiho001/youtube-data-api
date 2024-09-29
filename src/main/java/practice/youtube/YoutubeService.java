package practice.youtube;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;

@Service
public class YoutubeService {
    @Value("${youtube.api.key}")
    private String apiKey;
}
