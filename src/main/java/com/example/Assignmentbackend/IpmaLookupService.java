package com.example.Assignmentbackend;

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
    public CompletableFuture<String> getAllStationsData() throws InterruptedException {
        log.info("Getting Weather");
        String url = "https://api.ipma.pt/open-data/observation/meteorology/stations/observations.json";
        String results = restTemplate.getForObject(url, String.class);
        return CompletableFuture.completedFuture(results);
    }
}
