package com.example.Assignmentbackend.Services;

import com.example.Assignmentbackend.Models.Notification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Slf4j
@Service
public class SseService {
    public SseEmitter emitter;

    public SseEmitter registerClient() {
        emitter = new SseEmitter();
        emitter.onTimeout(() -> emitter.complete());
        return emitter;
    }

    public void sendEventToClients(String response) {
        Notification notification = Notification.builder()
                .message(response)
                .build();
            try {
                emitter.send(notification);
            } catch (Exception ignored) {}
    }
}
