package org.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.example.database.DatabaseClient;
import org.example.demo1.otherClasses.Account;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomePageForHotelManagerController implements Initializable {
    @FXML
    private Label emneiLabel;
    @FXML
    private ImageView amiLogo;
    @FXML
    private TextField hotelSearchBox;
    @FXML
    private ImageView settingsButton;
    @FXML
    private ImageView profileChobiEbongButton;
    @FXML
    private ImageView settingsButton1;
    @FXML
    private ImageView managerDp;
    @FXML
    private Label managerName;
    @FXML
    private Label managerEmail;
    @FXML
    private Label managerPhone;
    @FXML
    private Label managerAddress;
    @FXML
    private Label managerDob;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        managerName.setText(Account.loggedIn.getName());
        managerEmail.setText(Account.loggedIn.getEmail());
        managerPhone.setText(Account.loggedIn.getPhoneNumber());
        managerDob.setText(Account.loggedIn.getDateOfBirth());
        managerAddress.setText(Account.loggedIn.getAddress());
        Image image;
        try {
            image = DatabaseClient.stringToImage(Account.loggedIn.getProFilePhoto());
            managerDp.setImage(image);
            profileChobiEbongButton.setImage(image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        try {
//
//            image = ImageIO.read();
//            managerDp.setImage( image);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}
