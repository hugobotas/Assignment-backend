package com.example.Assignmentbackend.Controller;

import com.example.Assignmentbackend.Services.IpmaLookupService;
import com.example.Assignmentbackend.Services.MessagingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@Slf4j
@RestController
@RequestMapping("/trigger")
//@CrossOrigin(origins="")
public class TriggerController {
    private final IpmaLookupService ipmaLookupService;
    private final MessagingService messagingService;

    public TriggerController(IpmaLookupService ipmaLookupService, MessagingService messagingService) {
        this.ipmaLookupService = ipmaLookupService;
        this.messagingService = messagingService;
    }

    @GetMapping
    public ResponseEntity<String> triggerLookupService() {
        CompletableFuture<String> results = ipmaLookupService.getAllStationsData();
        results.thenAcceptAsync(messagingService::send);
//        return new ResponseEntity<>(results.get(), HttpStatus.OK);
        return ResponseEntity.accepted().build();
    }


}

