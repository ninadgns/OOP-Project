package org.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class hotelClickedController implements Initializable {
    public ImageView amiLogo;
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

    public void setHotelData(Map<String, Object> hotel) {
        hotelName.setText(hotel.get("name").toString());
        type.setText(hotel.get("type").toString());
        outdoor.setText(hotel.get("outdoorspace").toString());
        indoor.setText(hotel.get("indoorspace").toString());
        address.setText(hotel.get("address").toString());
        additionDescription.setText(hotel.get("additionaldescription").toString());

    }
}
