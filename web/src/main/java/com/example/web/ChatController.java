package com.example.web;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestBody String message) {
        chatService.broadcastMessage(message);
        return "Message sent successfully!";
    }
}
