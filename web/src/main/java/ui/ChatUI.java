package ui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.*;
import java.net.Socket;

public class ChatUI extends Application {

    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 8080;
    private PrintWriter out;

    @Override
    public void start(Stage primaryStage) {
        TextField messageInput = new TextField();
        TextArea chatArea = new TextArea();
        chatArea.setEditable(false);

        messageInput.setOnAction(e -> {
            String message = messageInput.getText();
            sendMessageToServer(message);
            messageInput.clear();
        });

        VBox root = new VBox(chatArea, messageInput);
        Scene scene = new Scene(root, 400, 300);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Chat Room");
        primaryStage.show();

        // Connect to the server
        connectToServer();

        // Start a thread to listen for messages from the server
        new Thread(() -> listenForMessages(chatArea)).start();
    }

    private void connectToServer() {
        try {
            Socket socket = new Socket(SERVER_HOST, SERVER_PORT);
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessageToServer(String message) {
        if (out != null) {
            out.println(message);
        }
    }

    private void listenForMessages(TextArea chatArea) {
        try {
            Socket socket = new Socket(SERVER_HOST, SERVER_PORT);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            final TextArea finalChatArea = chatArea; // Declare final variable
            String message;
            while ((message = in.readLine()) != null) {
                final String finalMessage = message; // Declare final variable
                Platform.runLater(() -> finalChatArea.appendText(finalMessage + "\n")); // Use final variable
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
