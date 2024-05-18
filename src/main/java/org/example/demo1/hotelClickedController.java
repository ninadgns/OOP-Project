package org.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.example.database.DatabaseClient;
import org.example.demo1.otherClasses.Account;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class hotelClickedController implements Initializable {
    public ImageView amiLogo;
    @FXML
    public HBox imageVbox;
    @FXML
    public VBox bairerVbox;
    @FXML
    public VBox vitorerVbox;
    @FXML
    public ImageView hostImage;
    @FXML
    public Label hostName;
    @FXML
    public Label hostPhone;
    @FXML
    public Label hostEmail;
    @FXML
    public Label hostAddress;
    @FXML
    public ChoiceBox guestCheckBox;
    @FXML
    private Label hotelName;
    @FXML
    private Label type;
    @FXML
    private Label indoor;
    @FXML
    private Label outdoor;
    @FXML
    private Label additionDescription;
    @FXML
    private Label address;

    public void handleChatManager(MouseEvent mouseEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setHotelData(Map<String, Object> hotel) throws IOException {
        hotelName.setText(hotel.get("name").toString());
        type.setText(hotel.get("type").toString());
        outdoor.setText(hotel.get("outdoorspace").toString());
        indoor.setText(hotel.get("indoorspace").toString());
        address.setText(hotel.get("address").toString());
        additionDescription.setText(hotel.get("additionaldescription").toString());
        if (!hotel.get("image1").toString().equals("sobinai")) {
            Image image = DatabaseClient.stringToImage(hotel.get("image1").toString());
            ImageView imageView = new ImageView();
            imageView.setImage(image);
            imageView.setFitHeight(100);
            imageView.setFitWidth(130);
            imageVbox.getChildren().add(imageView);
        }
        if (!hotel.get("image2").toString().equals("sobinai")) {
            Image image = DatabaseClient.stringToImage(hotel.get("image2").toString());
            ImageView imageView = new ImageView();
            imageView.setImage(image);
            imageView.setFitHeight(100);
            imageView.setFitWidth(130);

            imageVbox.getChildren().add(imageView);
        }
        if (!hotel.get("image3").toString().equals("sobinai")) {
            Image image = DatabaseClient.stringToImage(hotel.get("image3").toString());
            ImageView imageView = new ImageView();
            imageView.setImage(image);
            imageView.setFitHeight(100);
            imageView.setFitWidth(130);

            imageVbox.getChildren().add(imageView);
        }
        if (!hotel.get("image4").toString().equals("sobinai")) {
            Image image = DatabaseClient.stringToImage(hotel.get("image4").toString());
            ImageView imageView = new ImageView();
            imageView.setImage(image);
            imageView.setFitHeight(100);
            imageView.setFitWidth(130);

            imageVbox.getChildren().add(imageView);
        }

        try {
            String ownerId = hotel.get("ownerid").toString();

            var table = DatabaseClient.fetchWhere("accountinfo", "id='" + ownerId + "'");
            var row = table.get(0);
            Account host = Account.reTrieveAccount(row);
            hostImage.setImage(DatabaseClient.stringToImage(host.getProFilePhoto()));
            hostName.setText(host.getName());
            hostPhone.setText(host.getPhoneNumber());
            hostEmail.setText(host.getEmail());
            hostAddress.setText(host.getAddress());
        } catch (Exception e) {
        }
        String[] guestNumber = { "1", "2", "3", "4", "5", "6", "7"};
        guestCheckBox.getItems().addAll(guestNumber);

//        Account

    }
}
