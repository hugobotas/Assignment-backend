package com.example.Assignmentbackend;

import lombok.extern.slf4j.Slf4j;
import netscape.javascript.JSObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Component
public class AppRunner implements CommandLineRunner {

    private final IpmaLookupService ipmaLookupService;

    public AppRunner(IpmaLookupService ipmaLookupService) {
        this.ipmaLookupService = ipmaLookupService;
    }

    @Override
    public void run(String... args) throws Exception {
        long start = System.currentTimeMillis();
        CompletableFuture<String> results = ipmaLookupService.getLisbonData();
        log.info("Elapsed time: " + (System.currentTimeMillis() - start));
        log.info("--> " + results.get());


    }

}
