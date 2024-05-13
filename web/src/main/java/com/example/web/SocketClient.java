package com.example.web;

import java.io.*;
import java.net.Socket;

public class SocketClient {

    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 12345; // Adjust the port number as needed

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(SERVER_HOST, SERVER_PORT);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Send a message to the server
            out.println("Hello from the socket client!");

            // Receive a message from the server
            String response = in.readLine();
            System.out.println("Server response: " + response);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
