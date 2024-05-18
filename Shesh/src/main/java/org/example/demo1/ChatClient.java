package org.example.demo1;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import javafx.application.Platform;

public class ChatClient {
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;
    private String userName;

    private TelegramController controller;

    public ChatClient(String host, int port, TelegramController controller, String userName) {
        this.controller = controller;
        this.userName = userName;

        try {
            socket = new Socket(host, port);
            OutputStream output = socket.getOutputStream();
            writer = new PrintWriter(output, true);
            InputStream input = socket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(input));

            // Send the username immediately upon connection
            writer.println(userName);

            // Start a thread to read messages from the server
            new Thread(new ReadMessage()).start();
        } catch (IOException ex) {
            System.out.println("Error connecting to server: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        writer.println(message);
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);

        String text;

        do {
            text = scanner.nextLine();
            writer.println(text);

            if (text.startsWith("/msg")) {
                System.out.println("Type your message:");
                String message = scanner.nextLine();
                writer.println("/msg " + text.split(" ")[1] + " " + message);
            } else if (text.equals("/users")) {
                System.out.println("Fetching list of active users...");
            } else if (!text.equals("/quit")) {
                System.out.println("Message sent: " + text);
            }
        } while (!text.equals("/quit"));

        try {
            writer.close();
            reader.close();
            socket.close();
        } catch (IOException ex) {
            System.out.println("Error closing the connection: " + ex.getMessage());
        }
    }

    private class ReadMessage implements Runnable {
        public void run() {
            while (true) {
                try {
                    String response = reader.readLine();
                    if (response == null) break; // Server has closed the connection
                    System.out.println(response);

                    // Call showMsg method on the controller
                    Platform.runLater(() -> controller.showMsg(response));
                } catch (IOException ex) {
                    System.out.println("Error reading from server: " + ex.getMessage());
                    break;
                }
            }
        }
    }
}
