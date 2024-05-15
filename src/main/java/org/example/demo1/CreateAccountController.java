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
import org.example.demo1.otherClasses.Account;

import java.io.File;
import java.io.IOException;

public class CreateAccountController {
    Account account = new Account();
    @FXML
    private TextField fname;
    @FXML
    private Button signUpBtn;
    @FXML
    private TextField email;
    @FXML
    private TextField lname;
    @FXML
    private TextField pwd;
    @FXML
    private DatePicker dob;
    @FXML
    private TextField confirmPwd;
    @FXML
    private TextField phoneNo;
    @FXML
    private Button gotoSignInBtn;
    @FXML
    private RadioButton isCustomerRadio;
    @FXML
    private ToggleGroup isCustomerToggle;
    @FXML
    private RadioButton isHotelManagerRadio;
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

            Circle clip = new Circle(scaledWidth / 2, scaledHeight / 2, Math.min(scaledWidth, scaledHeight) / 2);
            formImage.setClip(clip);

            choosePhotoLabel.setText(selectedFile.getName());
        }
    }
    void exceptionGiver() throws Exception{
        if(fname.getText().isBlank()||lname.getText().isBlank()||email.getText().isBlank()||phoneNo.getText().isBlank()){
            throw new Exception();
        }
    }
    public void handleCreateAccount(ActionEvent actionEvent) {
        try{
        account.setFname(fname.getText());
        account.setLname(lname.getText());
        account.setFullName(fname.getText()+" "+lname.getText());
        account.setEmail(email.getText());
        account.setPassword(pwd.getText());
        account.setCustomer(isCustomerRadio.isSelected());
        account.setDateOfBirth(dob.getValue().toString());
        account.setPhoneNumber(phoneNo.getText());
        exceptionGiver();
        }
        catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error!");
            alert.setContentText("Fill all the fields properly");
            alert.show();
        }
        System.out.println(isCustomerRadio.isSelected());

        if(pwd.getText().equals(confirmPwd.getText())){
            try {
                Account.dbTeAccountPathai(account, "accountinfo", actionEvent);
                System.out.println("Account cholegese");
                handleGotoSignIn(actionEvent);
            }catch (Exception e){
                System.out.println("Error Paisi:\n"+e);
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText("Password Error!");
            alert.setContentText("Password and Confirm Password fields do not match!");
            alert.show();
//            ConfirmPasswordError.main();
        }
    }
}
