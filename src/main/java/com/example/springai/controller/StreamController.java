package com.example.springai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
public class StreamController {
    private final ChatClient chatClient;

    public StreamController(ChatClient chatClient) {

        this.chatClient = chatClient;
    }
    @GetMapping("/stream")
    public Flux<String> chat(@RequestParam("massage") String massage) {

        return chatClient.prompt()
                .user(massage).stream().content();
    }
}
