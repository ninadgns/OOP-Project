package com.example.web;

import java.io.*;
import java.net.Socket;

public class SocketHandler implements Runnable {

    private final Socket clientSocket;

    public SocketHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Handle communication with the client here

            // Example: sending a message to the client
            out.println("Hello from the server!");

            // Example: receiving a message from the client
            String message = in.readLine();
            System.out.println("Message from client: " + message);

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
