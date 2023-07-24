package com.example.Assignmentbackend.Controller;


import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import com.example.Assignmentbackend.Services.SseService;

import java.io.IOException;

@Controller
@RequestMapping("/sse")
@AllArgsConstructor
public class SseController {
    private final SseService sseService;

    @GetMapping("/receive")
    public SseEmitter getEmitter() {
        return sseService.registerClient();
    }

}