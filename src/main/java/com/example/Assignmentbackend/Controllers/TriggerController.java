package com.example.Assignmentbackend.Controllers;

import com.example.Assignmentbackend.Services.IpmaLookupService;
import com.example.Assignmentbackend.Services.SseService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/trigger")
@CrossOrigin(origins="http://localhost:5173/")
public class TriggerController {
    private final IpmaLookupService ipmaLookupService;
    private final SseService sseService;

    @GetMapping
    public ResponseEntity<Object> triggerLookupService() {
        CompletableFuture<String> results = ipmaLookupService.getAllStationsData();
        results.thenAcceptAsync(sseService::sendEventToClients);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


}

