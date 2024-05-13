package com.example.web;

import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChatService {

    private final List<SocketHandler> handlers = new ArrayList<>();

    public void addHandler(SocketHandler handler) {
        handlers.add(handler);
    }

    public void broadcastMessage(String message) {
        for (SocketHandler handler : handlers) {
            handler.sendMessage(message);
        }
    }
}

