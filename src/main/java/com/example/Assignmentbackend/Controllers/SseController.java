package com.example.Assignmentbackend.Controllers;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import com.example.Assignmentbackend.Services.SseService;

@Slf4j
@Controller
@RequestMapping("/sse")
@AllArgsConstructor
@CrossOrigin(origins="http://localhost:5173/")
public class SseController {
    private final SseService sseService;

    @GetMapping("/receive")
    public SseEmitter getEmitter() {
        log.info("Registered");
        return sseService.registerClient();
    }

}