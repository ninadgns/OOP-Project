package org.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class HelloController {
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
    private int ct = 0, downed=0;

//    public void handleBtn(ActionEvent actionEvent, boolean isLeft) {
//
//        if (messageText.getText().isEmpty()) return;
//
//        TextArea textArea = new TextArea(messageText.getText());
//        textArea.setEditable(false);
//        if (isLeft) {
//            textArea.setLayoutX(153);
//            textArea.getStyleClass().add("left");
//        }
//        else {
//            textArea.setLayoutX(345);
//            textArea.getStyleClass().add("right");
//        }
//        textArea.setLayoutY(297 - ct * 45);
//        textArea.setPrefWidth(156);
//        textArea.setPrefHeight(38);
//        System.out.println(ct);
//        anchorPane.getChildren().add(textArea);
//        ct++;
//        messageText.setText("");
//    }
//
//    public void handleBtnL(ActionEvent actionEvent) {
//        handleBtn(actionEvent, true);
//    }
//
//    public void handleBtnR(ActionEvent actionEvent) {
//        handleBtn(actionEvent, false);
//    }

    public void handleSendBtn(MouseEvent mouseEvent) {
        Label text = new Label(messageText.getText());
        text.getStyleClass().add("mechat");
        text.setMaxWidth(185);
        text.setWrapText(true);
        text.setLayoutX(150);
        double messageHeight = Math.ceil(messageText.getText().length() * FONT_SIZE / 185);
        text.setLayoutY(180 + (ct + 1) * 40);
        bgVboxL.getChildren().add(text);
        double f = Math.ceil(messageText.getText().length()*FONT_SIZE/185);

        // Calculate new scroll position
//        bgVboxL.setPrefHeight(bgVboxL.getHeight()+(f==1?0:0)*40);
        bgVboxL.setSpacing(5);
        double scrollPosition = (bgVboxR.getChildren().size() * 40) - rightScroll.getHeight();
        rightScroll.setVvalue(scrollPosition);
        messageText.setText("");

        // Update message count
        ct += 1;
    }

}