package org.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class CreateAccountController {
    public TextField fname;
    public Button signUpBtn;
    public TextField email;
    public TextField lname;
    public TextField pwd;
    public DatePicker dob;
    public TextField confirmPwd;
    public TextField phoneNo;
    public Button gotoSignInBtn;
    public RadioButton isCustomerRadio;
    public ToggleGroup isCustomerToggle;
    public RadioButton isHotelManagerRadio;
    @FXML
    private Label choosePhotoLabel;
    @FXML
    private Button choosePhotoBtn;
    @FXML
    private ImageView formImage;
    private Stage stage;
    private Scene scene;

    public void handleGotoSignIn(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("signinPage.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void handleChoosePhoto(ActionEvent actionEvent) {
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose an Image File");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif"));
        File selectedFile = fileChooser.showOpenDialog(stage);
        if(selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());

            // Calculate scaling factor
            double scaleFactor = Math.min(formImage.getFitWidth() / image.getWidth(), formImage.getFitHeight() / image.getHeight());

            // Calculate scaled dimensions
            double scaledWidth = image.getWidth() * scaleFactor;
            double scaledHeight = image.getHeight() * scaleFactor;

            // Set scaled image
            formImage.setImage(image);
            formImage.setFitWidth(scaledWidth);
            formImage.setFitHeight(scaledHeight);

            // Center the image in the ImageView
//            formImage.setX((formImage.getFitWidth() - scaledWidth) / 2);
//            formImage.setY((formImage.getFitHeight() - scaledHeight) / 2);
            // Clip the image to a circle
            Circle clip = new Circle(scaledWidth / 2, scaledHeight / 2, Math.min(scaledWidth, scaledHeight) / 2);
            formImage.setClip(clip);

            choosePhotoLabel.setText(selectedFile.getName());
        }
    }

}
