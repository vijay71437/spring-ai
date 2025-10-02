package com.example.springai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ChatController {
    private final ChatClient chatClient;

    public ChatController(ChatClient chatClient) {

        this.chatClient = chatClient;
    }
    @GetMapping("/chat1")
    public String chat(@RequestParam String masseges) {

        return chatClient.prompt()
                .user(masseges).call().content();
    }
}
