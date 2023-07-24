package com.example.Assignmentbackend.Services;

//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.concurrent.CompletableFuture;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;

@Service
@Slf4j
public class IpmaLookupService {
    private final RestTemplate restTemplate;

    public IpmaLookupService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Async
    public CompletableFuture<String> getAllStationsData() {
        log.info("Getting Weather");
        String url = "https://api.ipma.pt/open-data/observation/meteorology/stations/observations.json";
        String results = restTemplate.getForObject(url, String.class);
//        ObjectMapper temp = new ObjectMapper();
//        JsonNode actualObj;
//        try {
//            actualObj = temp.readTree(results);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
        delay(4000L);
        return CompletableFuture.completedFuture(results);
    }

    private static void delay(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
