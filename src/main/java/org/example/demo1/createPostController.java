package org.example.demo1;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class createPostController implements Initializable {
    @FXML
    private ChoiceBox<String> choiceBox;
    String [] bedroomNo = {"1", "2", "3"};
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.getItems().addAll(bedroomNo);
        choiceBox.setOnAction(this::selectChoiceBox);
    }

    private void selectChoiceBox(Event event)  {
        int n = Integer.parseInt((String) choiceBox.getValue());
        for (int i = 0; i < n; i++) {
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("bedroomPopup.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("styles.css")).toExternalForm());
//                Parent root = (Parent)
                Stage stage = new Stage();
                stage.setTitle("Hello!");
                stage.setX(500+i*100);
                stage.setScene(scene);
                stage.show();
            }catch (Exception e){
                System.out.println(e);
            }
        }
        System.out.println(n);
    }

    public void handleChooseThumbnailPhoto(ActionEvent actionEvent) {
    }

    public void handleChoosePhoto1(ActionEvent actionEvent) {
    }

    public void handleChoosePhoto2(ActionEvent actionEvent) {
    }

    public void handleChoosePhoto3(ActionEvent actionEvent) {
    }

    public void handleChoosePhoto4(ActionEvent actionEvent) {
    }

    public void handleChoosePhoto5(ActionEvent actionEvent) {
    }

    public void handleChoosePhoto6(ActionEvent actionEvent) {
    }

    public void handleGoBack(ActionEvent actionEvent) {

    }

}
