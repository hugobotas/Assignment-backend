package com.example.Assignmentbackend.Controllers;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import com.example.Assignmentbackend.Services.SseService;

@Controller
@RequestMapping("/sse")
@AllArgsConstructor

@CrossOrigin(origins="http://localhost:8000")
public class SseController {
    private final SseService sseService;

    @GetMapping("/receive")
    public SseEmitter getEmitter() {
        return sseService.registerClient();
    }

}