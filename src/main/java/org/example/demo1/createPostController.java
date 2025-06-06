package org.example.demo1;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.example.Manage.*;
import org.example.database.DatabaseClient;
import org.example.demo1.otherClasses.Account;

import java.io.File;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class createPostController implements Initializable {
    @FXML
    private BorderPane borderPane;
    @FXML
    private TextField hotelName;
    @FXML
    private TextField address;
    @FXML
    private TextField longDescription;
    @FXML
    private TextField totalSqft;
    @FXML
    private RadioButton rYard;
    @FXML
    private RadioButton rPatio;
    @FXML
    private RadioButton rGarage;
    @FXML
    private RadioButton rSwim;
    @FXML
    private VBox photoVbox;
    @FXML
    private HBox photoHbox;
    @FXML
    private Button choosePhotoBtn1;
    @FXML
    private Label choosePhotoLabel1;
    @FXML
    private Button choosePhotoBtn2;
    @FXML
    private Label choosePhotoLabel11;
    @FXML
    private Label choosePhotoLabel2;
    @FXML
    private Button choosePhotoBtn3;
    @FXML
    private Label choosePhotoLabel3;
    @FXML
    private Button choosePhotoBtn4;
    @FXML
    private Label choosePhotoLabel4;
    @FXML
    private Button choosePhotoBtn5;
    @FXML
    private Label choosePhotoLabel5;
    @FXML
    private Button choosePhotoBtn6;
    @FXML
    private Label choosePhotoLabel6;
    @FXML
    private RadioButton rCabin;
    @FXML
    private ToggleGroup hotelType;
    @FXML
    private RadioButton rCottage;
    @FXML
    private RadioButton rAFrames;
    @FXML
    private RadioButton rVilla;
    @FXML
    private RadioButton rKitchen;
    @FXML
    private RadioButton rLounge;
    @FXML
    private RadioButton rDining;
    @FXML
    private TextField district;
    @FXML
    private Button goBackBtn;
    @FXML
    private ChoiceBox<String> choiceBox;
    String[] bedroomNo = { "1", "2", "3" };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.getItems().addAll(bedroomNo);
        choiceBox.setOnAction(this::selectChoiceBox);
    }

    private void selectChoiceBox(Event event) {
        int n = Integer.parseInt((String) choiceBox.getValue());
        for (int i = 0; i < n; i++) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("bedroomPopup.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                scene.getStylesheets()
                        .add(Objects.requireNonNull(getClass().getResource("styles.css")).toExternalForm());
                // Parent root = (Parent)
                Stage stage = new Stage();
                stage.setTitle("Book Stay");
                stage.setX(500 + i * 100);
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        System.out.println(n);
    }

    public void handleChooseThumbnailPhoto(ActionEvent actionEvent) {
    }

    public void handleChoosePhoto1(ActionEvent actionEvent) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose an Image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );

        // Get the stage to show the FileChooser dialog
        Stage stage = (Stage) photoHbox.getScene().getWindow();

        // Show the file chooser dialog
        Account.image1 = fileChooser.showOpenDialog(stage);

        if (Account.image1 != null) {
            // Set the label to display the selected file's name
            choosePhotoLabel1.setText(Account.image1.getName());
        } else {
            choosePhotoLabel1.setText("No image chosen");
        }
    }



    public void handleChoosePhoto2(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose an Image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );

        // Get the stage to show the FileChooser dialog
        Stage stage = (Stage) photoHbox.getScene().getWindow();

        // Show the file chooser dialog
        Account.image2 = fileChooser.showOpenDialog(stage);

        if (Account.image2 != null) {
            // Set the label to display the selected file's name
            choosePhotoLabel2.setText(Account.image2.getName());
        } else {
            choosePhotoLabel2.setText("No image chosen");
        }
    }

    public void handleChoosePhoto3(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose an Image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );

        // Get the stage to show the FileChooser dialog
        Stage stage = (Stage) photoHbox.getScene().getWindow();

        // Show the file chooser dialog
        Account.image3 = fileChooser.showOpenDialog(stage);

        if (Account.image3 != null) {
            // Set the label to display the selected file's name
            choosePhotoLabel3.setText(Account.image3.getName());
        } else {
            choosePhotoLabel3.setText("No image chosen");
        }
    }

    public void handleChoosePhoto4(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose an Image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );

        // Get the stage to show the FileChooser dialog
        Stage stage = (Stage) photoHbox.getScene().getWindow();

        // Show the file chooser dialog
        Account.image4 = fileChooser.showOpenDialog(stage);

        if (Account.image4 != null) {
            // Set the label to display the selected file's name
            choosePhotoLabel4.setText(Account.image4.getName());
        } else {
            choosePhotoLabel4.setText("No image chosen");
        }
    }

    public void handleChoosePhoto5(ActionEvent actionEvent) {
    }

    public void handleChoosePhoto6(ActionEvent actionEvent) {
    }

    public void handleGoBack(ActionEvent actionEvent) {

    }

    public void handlePostBtn(ActionEvent actionEvent) {
        if (rCabin.isSelected()) {
            Account.hotel = new Cabin(address.getText(), district.getText(), hotelName.getText(),
                    Double.parseDouble(totalSqft.getText()));
        } else if (rCottage.isSelected()) {
            Account.hotel = new Cottage(address.getText(), district.getText(), hotelName.getText(),
                    Double.parseDouble(totalSqft.getText()));

        } else if (rAFrames.isSelected()) {
            Account.hotel = new AFrames(address.getText(), district.getText(), hotelName.getText(),
                    Double.parseDouble(totalSqft.getText()));
        } else if (rVilla.isSelected()) {
            Account.hotel = new Villa(address.getText(), district.getText(), hotelName.getText(),
                    Double.parseDouble(totalSqft.getText()));
        }
        CommonSpace indoor = new IndoorSpace();
        CommonSpace outdoor = new OutdoorSpace();
        if (rYard.isSelected()) {
            outdoor = new Yard(outdoor);
        }
        if (rPatio.isSelected()) {
            outdoor = new Patio(outdoor);
        }
        if (rGarage.isSelected()) {
            outdoor = new Garage(outdoor);
        }
        if (rSwim.isSelected()) {
            outdoor = new SwimmingPool(outdoor);
        }
        if (rKitchen.isSelected()) {
            indoor = new Kitchen(indoor);
        }
        if (rLounge.isSelected()) {
            indoor = new Lounge(indoor);
        }
        if (rDining.isSelected()) {
            indoor = new Dining(indoor);
        }

        Account.hotel.setOtherFacility(new House(indoor, outdoor));

        Account.hotel.setAdditionalDescription(longDescription.getText());
        Account.hotel.setRoomList(Account.rooms);
        Account.hotel.setOwnerID(Account.loggedIn.getId());
        Hotel.lastHotelID++;
        Account.hotel.setHotelID(Hotel.lastHotelID);
        Account.dbTeHotelPathai();

        Stage stage = (Stage) borderPane.getScene().getWindow();

        stage.close();
    }
}
