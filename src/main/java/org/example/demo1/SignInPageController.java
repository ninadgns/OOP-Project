package org.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.database.DatabaseClient;

import java.io.IOException;

public class SignInPageController {
    @FXML
    private Button gotoCreateAccountBtn;
    @FXML
    private TextField enterEmailToSignIn;
    @FXML
    private TextField enterPwdToSignIn;
    @FXML
    private Button signInBtnToSignIn;
    @FXML
    private Label forgotPwd;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;


    public void handleGotoCreateAccount(ActionEvent actionEvent) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("createAccountPage.fxml"));
            Parent root = loader.load();
            stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
//            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void auth() throws Exception{
        var table = DatabaseClient.fetch("accountinfo");
        boolean f = false;
        for(var row: table){
            if(row.get("email").equals(enterEmailToSignIn.getText())){
                if(!row.get("password").equals(enterPwdToSignIn.getText())){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Wrong Password");
                    alert.setContentText("Enter Correct Password");
                    alert.show();
                    throw new Exception("Wrong Password");
                }
                else {
                    f = true;
                    break;
                }
            }
        }
        if(!f){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Email Not Found");
            alert.setContentText("Create An Account To Login");
            alert.show();
            throw new Exception("Email Not Found");
        }

    }
    public void handleSignInBtnToSignIn(ActionEvent actionEvent) throws IOException {


        try {
            auth();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
            Parent root = loader.load();

            HomePageController homePageController = loader.getController();
            homePageController.setLabelData(enterEmailToSignIn.getText());
            System.out.println(enterEmailToSignIn.getText());
            stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }

}
