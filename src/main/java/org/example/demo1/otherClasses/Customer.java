package org.example.demo1.otherClasses;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.demo1.SignInPageController;

import java.io.IOException;

public class Customer implements Client {

    @Override
    public void setPage(ActionEvent actionEvent, Class<? extends SignInPageController> aClass) throws IOException {
        FXMLLoader loader = new FXMLLoader(aClass.getResource("HomePageForCustomer.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
}
