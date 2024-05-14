package org.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SignInPageController {
    public Button gotoCreateAccountBtn;
    public TextField enterEmailToSignIn;
    public TextField enterPwdToSignIn;
    public Button signInBtnToSignIn;
    public Label forgotPwd;
    private Stage stage;
    private Scene scene;


    public void handleGotoCreateAccount(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("createAccountPage.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
