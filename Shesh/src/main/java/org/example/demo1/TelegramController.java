package org.example.demo1;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import java.util.Optional;

import org.example.demo1.otherClasses.Account;

public class TelegramController {
    final double FONT_SIZE = 7.115384615;
    @FXML
    public VBox bgVboxL;
    @FXML
    public VBox bgVboxR;
    @FXML
    private VBox bgVbox;
    @FXML
    private ScrollPane rightScroll;
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

    @FXML
    public void initialize() {
        System.out.println("bgVboxL initialized: " + (bgVboxL != null));
        System.out.println("bgVboxR initialized: " + (bgVboxR != null));
        System.out.println("rightScroll initialized: " + (rightScroll != null));
        client = new ChatClient("localhost", 6666, this, Account.loggedIn.getId());

    }

    @FXML
    public void handleSendBtn(MouseEvent mouseEvent) {
        String message = messageText.getText().trim();
        if (!message.isEmpty()) {
            client.sendMessage("/msg " + message);
            displaySentMessage(message);
            messageText.setText("");
        } else {
            System.out.println("Message text is empty"); // Debug print
        }
    }

    private void displaySentMessage(String message) {
        Label text = new Label(message);
        text.getStyleClass().add("mechat");
        text.setMaxWidth(185);
        text.setWrapText(true);
        text.setLayoutX(150);
        double messageHeight = Math.ceil(message.length() * FONT_SIZE / 185);
        text.setLayoutY(180 + (ct + 1) * 40);
        bgVboxR.getChildren().add(text);
        bgVboxR.setSpacing(5);
        rightScroll.setVvalue(1.0); // Auto-scroll to the bottom
        ct += 1;
    }

    public void displayMessage(String message) {
        Platform.runLater(() -> {
            System.out.println("Displaying message: " + message);
            Label text = new Label(message);
            text.getStyleClass().add("mechat");
            text.setMaxWidth(185);
            text.setWrapText(true);
            text.setLayoutX(150);
            double messageHeight = Math.ceil(message.length() * FONT_SIZE / 185);
            text.setLayoutY(180 + (ct + 1) * 40);
            bgVboxR.getChildren().add(text);
            bgVboxR.setSpacing(5);
            rightScroll.setVvalue(1.0); // Auto-scroll to the bottom
            ct += 1;
        });
    }

    void showMsg(String msg) {
        Platform.runLater(() -> {
            Label text = new Label(msg);
            text.getStyleClass().add("mechat");
            text.setMaxWidth(185);
            text.setWrapText(true);
            text.setLayoutX(150);
            double messageHeight = Math.ceil(msg.length() * FONT_SIZE / 185);
            text.setLayoutY(180 + (ct + 1) * 40);
            bgVboxL.getChildren().add(text);
            bgVboxL.setSpacing(5);
            rightScroll.setVvalue(1.0); // Auto-scroll to the bottom
            messageText.setText("");
            ct += 1;
        });
    }

    private void handleBtn(ActionEvent actionEvent, boolean isLeft) {
        String message = messageText.getText().trim();
        if (message.isEmpty()) {
            System.out.println("Message text is empty"); // Debug print
            return;
        }

        System.out.println("Handling button click, isLeft: " + isLeft);
        TextArea textArea = new TextArea(message);
        textArea.setEditable(false);
        textArea.setPrefWidth(300);
        textArea.setWrapText(true);

        if (isLeft) {
            textArea.getStyleClass().add("left");
            bgVboxL.getChildren().add(textArea);
        } else {
            textArea.getStyleClass().add("right");
            bgVboxR.getChildren().add(textArea);
        }

        rightScroll.setVvalue(1.0); // Auto-scroll to the bottom
        messageText.setText(""); // Clear the input field

        System.out.println("Message displayed: " + message); // Debug print
    }

}