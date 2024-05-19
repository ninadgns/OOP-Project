package org.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.example.Manage.AFrames;
import org.example.Manage.Cabin;
import org.example.Manage.Cottage;
import org.example.Manage.Villa;
import javafx.stage.Stage;
import org.example.database.DatabaseClient;
import org.example.demo1.otherClasses.Account;

import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.BlockingQueue;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;

public class HomePageForCustomerController implements Initializable {
    @FXML
    private Label hotelName;
    @FXML
    private Label hotelDistrict;
    @FXML
    private Label hotelAddress;
    @FXML
    private Label hotelFloorSpace;
    @FXML
    private Label hotelCost;
    @FXML
    private Label emneiLabel;
    @FXML
    private ImageView amiLogo;
    @FXML
    private ImageView settingsButton;
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
    private ImageView profileChobiEbongButton;
    @FXML
    public TextField hotelSearchBox;
    @FXML
    private VBox homePageVbox;
    // @FXML
    // private Button handleDonebtn;

    @FXML
    private RadioButton rCabin;
    @FXML
    private ToggleGroup hotelType;
    @FXML
    private RadioButton rCottage;
    @FXML
    private RadioButton rAFrame;
    @FXML
    private RadioButton rVilla;
    private BlockingQueue<Map<String, Object>> hotelIdsonType;
    private BlockingQueue<Map<String, Object>> hotelIdsBasedOnArea;

    public void setLabelData(String s) {
        emneiLabel.setText(s);
    }

    public void handleDoneBtn(ActionEvent actionEvent) {
        hotelIdsBasedOnArea = new LinkedBlockingQueue<>();
        String str = hotelSearchBox.getText();
        // System.out.println(str);
        homePageVbox.getChildren().clear();
        for (var hotel : HelloApplication.allHotels) {
            if (str.equals(hotel.get("district"))) {
                hotelIdsBasedOnArea.add(hotel);
            }
        }
        for (var hotel : hotelIdsBasedOnArea) {
            try {
                showHotels(hotel);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void handleTypeDone(ActionEvent actionEvent) {
        hotelIdsonType = new LinkedBlockingQueue<>();
        String selType = null;
        if (rAFrame.isSelected()) {
            selType = "AFrame";
        } else if (rCabin.isSelected()) {
            selType = "Cabin";
        } else if (rCottage.isSelected()) {
            selType = "Cottage";
        } else if (rVilla.isSelected()) {
            selType = "Villa";
        }
        if (hotelIdsBasedOnArea != null) {
            for (var hotel : hotelIdsBasedOnArea) {
                if (selType.equals(hotel.get("type"))) {
                    hotelIdsonType.add(hotel);
                }
            }
        } else {
            for (var hotel : HelloApplication.allHotels) {
                if (selType.equals(hotel.get("type"))) {
                    hotelIdsonType.add(hotel);
                }
            }
        }
        homePageVbox.getChildren().clear();
        for (var hotel : hotelIdsonType) {

            try {
                showHotels(hotel);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void showHotels(Map<String, Object> hotel) throws Exception {

        Rectangle smallRectangle = new Rectangle(140, 100);
        homePageVbox.setPadding(new Insets(5));
        smallRectangle.setFill(Color.BLUE);

        String str1 = (String) hotel.get("image1");
        if (str1 != null && !str1.isEmpty() && !str1.equals("sobinai")) {
            Image image1 = DatabaseClient.stringToImage(str1);

            if (image1 != null) {
                smallRectangle.setFill(new ImagePattern(image1));
            }
        }

        StringBuilder str = new StringBuilder();
        // int cost=hotel.get("costpernight");
        str.append("Name: ").append((String) hotel.get("name")).append("\n")
                .append("Address: ").append((String) hotel.get("address")).append("\n")
                .append("Cost Per Night: ").append(hotel.get("costpernight")).append("\n");
        String data = str.toString();

        System.out.println(data);
        Label descriptionLabel = new Label(data);
        descriptionLabel.setWrapText(true);
        descriptionLabel.setMaxWidth(300);
        descriptionLabel.setPrefWidth(300);
        descriptionLabel.setPrefHeight(200);
        descriptionLabel.setStyle("-fx-text-fill: black; -fx-padding: 3px;");

        VBox vBox = new VBox();
        vBox.setPrefWidth(200);
        vBox.setPrefHeight(300);
        vBox.getChildren().addAll(smallRectangle, descriptionLabel);
        vBox.setSpacing(5);

        StackPane stackPane = new StackPane(vBox);
        stackPane.setPrefWidth(200);
        stackPane.setPrefHeight(300);
        stackPane.setPadding(new Insets(5));

        // Store hotel information in StackPane
        stackPane.setUserData(hotel);

        stackPane.setOnMouseClicked(this::handleRectangleClick);

        HBox f = null;

        int childrenSize = homePageVbox.getChildren().size();
        if (childrenSize == 0) {
            HBox hB = new HBox();
            hB.setMinHeight(300);
            homePageVbox.getChildren().add(hB);
        } else {
            f = (HBox) homePageVbox.getChildren().getLast();
            if (f.getChildren().size() == 4) {
                homePageVbox.getChildren().add(new HBox());
            }
        }

        HBox hBox = (HBox) homePageVbox.getChildren().getLast();
        hBox.getChildren().add(stackPane);
        homePageVbox.getChildren().remove(homePageVbox.getChildren().getLast());
        homePageVbox.setSpacing(5);
        hBox.setSpacing(5);
        homePageVbox.getChildren().add(hBox);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (var hotel : HelloApplication.allHotels) {
            try {
                showHotels(hotel);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            System.out.println(Account.loggedIn.getFullName());
//            profileChobiEbongButton.setImage(image);
//            var table = DatabaseClient.fetchWhere("accountinfo", "email='" + Account.loggedIn.getEmail() + "'");
//            var row = table.get(0);
            Image image = DatabaseClient.stringToImage(Account.loggedIn.getProFilePhoto());
//            image.isPreserveRatio(false);
            profileChobiEbongButton.setImage(image);

        } catch (Exception e) {
//            throw new RuntimeException(e);
        }
        // File file = null;
        // try {
        // file = DatabaseClient.stringToFile(Account.loggedIn.getProFilePhoto());
        // Image image = new Image(file.toURI().toString());
        // profileChobiEbongButton.setImage(image); // Set image to the existing
        // ImageView instance
        // } catch (IOException e) {
        // throw new RuntimeException(e);
        // }
        //
    }

    public void handleRectangleClick(MouseEvent event) {
        StackPane clickedPane = (StackPane) event.getSource();
        Map<String, Object> hotel = (Map<String, Object>) clickedPane.getUserData();

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hotelClicked.fxml"));
            Parent root = fxmlLoader.load();

            // Get the controller of the new scene
            hotelClickedController controller = fxmlLoader.getController();
            // Pass the hotel information to the controller
            controller.setHotelData(hotel, hotel.get("id").toString());

            Scene scene = new Scene(root);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("styles.css")).toExternalForm());

            Stage stage = new Stage();
            stage.setTitle("Hotel Details");
            stage.setScene(scene);
            stage.setWidth(800); // Set desired width
            stage.setHeight(600); // Set desired height
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handleChatButton(MouseEvent mouseEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("telegram.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            scene.getStylesheets()
                    .add(Objects.requireNonNull(getClass().getResource("styles.css")).toExternalForm());
            Stage stage = new Stage();
            stage.setTitle("Book Stay");
            stage.setX(500 + 100);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void handleProfile(MouseEvent mouseEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomerProfile.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            // stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
