package org.example.demo1;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.example.database.DatabaseClient;
import org.example.demo1.otherClasses.Account;

public class TelegramController {


    String ChatServerIP = "localhost";
    int ChatServerPort = 6666;



    final double FONT_SIZE = 7.115384615;
    @FXML
    private VBox bgVbox;
    @FXML
    private ScrollPane rightScroll;
    @FXML
    private VBox naamerList;
    @FXML
    private AnchorPane chatPanel;
    @FXML
    private ImageView sendBtn;
    @FXML
    private Button BtnL;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextField messageText;
    @FXML
    private Button BtnR;
    private ChatClient client;

    private int ct = 0, downed = 0;

    // public void handleBtn(ActionEvent actionEvent, boolean isLeft) {
    // if (messageText.getText().isEmpty())
    // return;
    // TextArea textArea = new TextArea(messageText.getText());
    // textArea.setEditable(false);
    // if (isLeft) {
    // textArea.setLayoutX(153);
    // textArea.getStyleClass().add("left");
    // } else {
    // textArea.setLayoutX(345);
    // textArea.getStyleClass().add("right");
    // }
    // textArea.setLayoutY(297 - ct * 45);
    // textArea.setPrefWidth(156);
    // textArea.setPrefHeight(38);
    // System.out.println(ct);
    // anchorPane.getChildren().add(textArea);
    // ct++;
    // messageText.setText("");
    // }
    // public void handleBtnL(ActionEvent actionEvent) {
    // handleBtn(actionEvent, true);
    // }
    // public void handleBtnR(ActionEvent actionEvent) {
    // handleBtn(actionEvent, false);
    // }
    // public void handleSendBtn(MouseEvent mouseEvent) {
    // Label text = new Label(messageText.getText());
    // text.getStyleClass().add("mechat");
    // text.setMaxWidth(185);
    // text.setWrapText(true);
    // text.setLayoutX(150);
    // double messageHeight = Math.ceil(messageText.getText().length() * FONT_SIZE /
    // 185);
    // text.setLayoutY(180 + (ct + 1) * 40);
    // bgVboxL.getChildren().add(text);
    // double f = Math.ceil(messageText.getText().length()*FONT_SIZE/185);
    // // Calculate new scroll position
    // // bgVboxL.setPrefHeight(bgVboxL.getHeight()+(f==1?0:0)*40);
    // bgVboxL.setSpacing(5);
    // double scrollPosition = (bgVboxR.getChildren().size() * 40) -
    // rightScroll.getHeight();
    // rightScroll.setVvalue(scrollPosition);
    // messageText.setText("");
    // // Update message count
    // ct += 1;
    // }
    // public TelegramController() {
    // TextInputDialog dialog = new TextInputDialog();
    // dialog.setTitle("Chat Login");
    // dialog.setHeaderText("Enter Your Username:");
    // Optional<String> result = dialog.showAndWait();
    // String string = "127.0.0.1";
    // result.ifPresent(username ->
    // client = new ChatClient(string, 6666, this, username)
    // );
    // }

    String receiver = new String();

    @FXML
    public void initialize() {
        System.out.println("bgVbox initialized: " + (bgVbox != null));
        // System.out.println("bgVboxR initialized: " + (bgVboxR != null));
        System.out.println("rightScroll initialized: " + (rightScroll != null));
        // try {
        //     var hostrs = DatabaseClient.runSQL("Select * from messages where id = 1");
        //     if (hostrs.next()) {
        //         host = hostrs.getString("content");
        //         port = hostrs.getInt("receiver_id");
        //     }
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        client = new ChatClient(ChatServerIP, ChatServerPort, this, Account.loggedIn.getId());
        var a = getSenders(Account.loggedIn.getId());
        for (SenderData senderData : a) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AnchorPaneTemplate.fxml"));
            try {
                AnchorPane anchorPane = loader.load();
                Label textNode = new Label();
                textNode.setText(senderData.name);
                textNode.setStyle("-fx-font-size: 18; -fx-text-fill: white;-fx-margin: 10px  10px 10px 10px;"); // Set the font size
                textNode.setTextAlignment(TextAlignment.CENTER); // Center align the text

                VBox.setVgrow(textNode, Priority.ALWAYS); // Vertically center the text
                VBox vBox = (VBox) anchorPane.getChildren().get(0); // Get the VBox from AnchorPane
                vBox.setAlignment(Pos.CENTER_LEFT); // Center align the VBox content (textNode)
                anchorPane.setOnMouseClicked((MouseEvent event) -> {
                    System.out.println("AnchorPane is clicked!" + senderData.name);
                    bgVbox.getChildren().clear();
                    receiver = senderData.sender_id;

                    String messagesSql = "SELECT * FROM messages WHERE (sender_id = " + Account.loggedIn.id
                            + " AND receiver_id = "
                            + senderData.sender_id + ") OR (sender_id = " + senderData.sender_id + " AND receiver_id = "
                            + Account.loggedIn.id
                            + ") ORDER BY id ASC;";

                    ResultSet messagesResultSet = DatabaseClient.runSQL(messagesSql);
                    List<String> messagesSentByMe = new ArrayList<>();
                    List<String> messagesSentByOtherPerson = new ArrayList<>();
                    try {
                        while (messagesResultSet.next()) {
                            // Message message = new Message(messagesResultSet);
                            // if (message.getSenderId() == userId1) {
                            // messagesSentByUser1.add(message);
                            // } else if (message.getSenderId() == userId2) {
                            // messagesSentByUser2.add(message);
                            // }
                            var message_sender_id = messagesResultSet.getString("sender_id");
                            System.out.println(message_sender_id + " " + senderData.sender_id);
                            if (Integer.parseInt(message_sender_id) == Integer.parseInt(senderData.sender_id)) {
                                // messagesSentByOtherPerson.add();
                                displayReceivedMessage(messagesResultSet.getString("content"));
                                // System.out.println("bame dilam");
                            } else {
                                displaySentMessage(messagesResultSet.getString("content"));
                                // System.out.println("dane dilam");
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                });

                vBox.getChildren().add(textNode);
                naamerList.getChildren().add(anchorPane);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public class SenderData {
        String name;
        int lastMessageId;
        String sender_id;

        public SenderData(String name, int lastMessageId, String sender_id) {
            this.name = name;
            this.lastMessageId = lastMessageId;
            this.sender_id = sender_id;
        }

        public String getName() {
            return name;
        }

        public int getLastMessageId() {
            return lastMessageId;
        }

        public String getSenderId() {
            return sender_id;
        }

    }

    public List<SenderData> getSenders(String receiverId) {
        try {
            String sql = "SELECT m2.last_message_id, u.name,  m2.sender_id FROM ( SELECT sender_id, MAX(id) as last_message_id FROM messages WHERE receiver_id = "
                    + receiverId
                    + " GROUP BY sender_id) m2 JOIN accountinfo u ON u.id = m2.sender_id ORDER BY m2.last_message_id DESC;";

            ResultSet resultSet = DatabaseClient.runSQL(sql);

            List<SenderData> senderDataList = new ArrayList<>();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int lastMessageId = resultSet.getInt("last_message_id");
                String sender_id = resultSet.getString("sender_id");

                SenderData senderData = new SenderData(name, lastMessageId, sender_id);
                senderDataList.add(senderData);
            }

            return senderDataList;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new ArrayList<>(); // Return an empty list if there was an exception
    }

    @FXML
    public void handleSendBtn(MouseEvent mouseEvent) {
        String message = messageText.getText().trim();
        if (!message.isEmpty()) {
            client.sendMessage("/msg " + receiver + " " + message);
            displaySentMessage(message);
            messageText.setText("");
        } else {
            System.out.println("Message text is empty"); // Debug print
        }

    }

    private void displaySentMessage(String message) {
        Label text = new Label(message);
        text.getStyleClass().add("mechat");
        text.setMaxWidth(200);
        text.setWrapText(true);

        HBox hbox = new HBox();
        hbox.getChildren().add(text);
        hbox.setAlignment(Pos.CENTER_RIGHT); // Aligns the message to the right

        bgVbox.getChildren().add(hbox);
        bgVbox.setSpacing(5);
        rightScroll.setVvalue(1.0); // Auto-scroll to the bottom
        ct += 1;
    }

    void displayReceivedMessage(String message) {
        Label text = new Label(message);
        text.getStyleClass().add("mechat");
        text.setMaxWidth(200);
        text.setWrapText(true);

        HBox hbox = new HBox();
        hbox.getChildren().add(text);
        hbox.setAlignment(Pos.CENTER_LEFT); // Aligns the message to the left

        bgVbox.getChildren().add(hbox);
        bgVbox.setSpacing(5);
        rightScroll.setVvalue(1.0); // Auto-scroll to the bottom
        ct += 1;
    }

    // void displaySentMessage(String message) {
    // Label text = new Label(message);
    // text.getStyleClass().add("mechat-sent");

    // text.setMaxWidth(185);
    // text.setWrapText(true);
    // text.setLayoutX(150);
    // double messageHeight = Math.ceil(message.length() * FONT_SIZE / 185);
    // text.setLayoutY(180 + (ct + 1) * 40);
    // bgVbox.getChildren().add(text);
    // bgVbox.setSpacing(5);
    // rightScroll.setVvalue(1.0); // Auto-scroll to the bottom
    // ct += 1;
    // }

    // void displayReceivedMessage(String msg) {
    // Platform.runLater(() -> {
    // Label text = new Label(msg);
    // text.getStyleClass().add("mechat-received");

    // text.setMaxWidth(185);
    // text.setWrapText(true);
    // text.setLayoutX(0);
    // double messageHeight = Math.ceil(msg.length() * FONT_SIZE / 185);
    // text.setLayoutY(180 + (ct + 1) * 40);
    // bgVbox.getChildren().add(text);
    // bgVbox.setSpacing(5);
    // rightScroll.setVvalue(1.0); // Auto-scroll to the bottom
    // messageText.setText("");
    // ct += 1;
    // });
    // }

    // public void displayMessage(String message) {
    // Platform.runLater(() -> {
    // System.out.println("Displaying message: " + message);
    // Label text = new Label(message);
    // text.getStyleClass().add("mechat");
    // text.setMaxWidth(185);
    // text.setWrapText(true);
    // text.setLayoutX(150);
    // double messageHeight = Math.ceil(message.length() * FONT_SIZE / 185);
    // text.setLayoutY(180 + (ct + 1) * 40);
    // bgVboxR.getChildren().add(text);
    // bgVboxR.setSpacing(5);
    // rightScroll.setVvalue(1.0); // Auto-scroll to the bottom
    // ct += 1;
    // });
    // }

    // private void handleBtn(ActionEvent actionEvent, boolean isLeft) {
    // String message = messageText.getText().trim();
    // if (message.isEmpty()) {
    // System.out.println("Message text is empty"); // Debug print
    // return;
    // }
    // System.out.println("Handling button click, isLeft: " + isLeft);
    // TextArea textArea = new TextArea(message);
    // textArea.setEditable(false);
    // textArea.setPrefWidth(300);
    // textArea.setWrapText(true);
    // if (isLeft) {
    // textArea.getStyleClass().add("left");
    // bgVboxL.getChildren().add(textArea);
    // } else {
    // textArea.getStyleClass().add("right");
    // bgVboxR.getChildren().add(textArea);
    // }
    // rightScroll.setVvalue(1.0); // Auto-scroll to the bottom
    // messageText.setText(""); // Clear the input field
    // System.out.println("Message displayed: " + message); // Debug print
    // }

}