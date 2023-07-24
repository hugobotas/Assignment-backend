package com.example.Assignmentbackend.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessagingService {

    public void send(String s) {
        log.info(s);
    }
}
