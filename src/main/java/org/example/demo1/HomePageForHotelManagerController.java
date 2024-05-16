package org.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class HomePageForHotelManagerController {
    public Label emneiLabel;
    @FXML
    private VBox homePageVbox;
    @FXML
    private Button tipDeoBtn;
    public void setLabelData(String s){
        emneiLabel.setText(s);
    }
    public void handleTipDeo(ActionEvent actionEvent) {
        Rectangle rectangle = new Rectangle(200, 200);
        homePageVbox.setPadding(new Insets(5));
        rectangle.setFill(Color.BLUE);
        HBox f = (HBox) homePageVbox.getChildren().getLast();
        if (homePageVbox.getChildren().size() == 1 || f.getChildren().size() == 4) {
            homePageVbox.getChildren().add(new HBox());

        }

        HBox hBox = (HBox) homePageVbox.getChildren().getLast();
        hBox.getChildren().add(rectangle);
        homePageVbox.getChildren().remove(homePageVbox.getChildren().getLast());
//        homePageVbox.(new Insets(5));
        homePageVbox.setSpacing(5);
        hBox.setSpacing(5);
        homePageVbox.getChildren().add(hBox);

    }

}