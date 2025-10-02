package com.example.springai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatClientConfig {
    @Bean
    public ChatClient chatClient(ChatClient.Builder chatClient) {
        return chatClient
                .defaultSystem("""
                        You are an internal IT assistant. Your role is to help \s
                        employees with Questions related to IT policies,Such as \s
                        Reset account policies, help to download software  ,email account reset.
                        If a user asks for help with anything outside of these topics,\s
                        Kindly inform them that you can only assist with queries related to \s
                        HR policies.
                        """)
                .build();
    }
}
