package org.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
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
    private static ImageView profileChobiEbongButton;
    @FXML
    public TextField hotelSearchBox;
    @FXML
    private VBox homePageVbox;
//   @FXML
//   private Button handleDonebtn;

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
    private BlockingQueue<Map<String,Object>> hotelIdsonType;
    private BlockingQueue<Map<String,Object>> hotelIdsBasedOnArea;
    public void setLabelData(String s){
        emneiLabel.setText(s);
    }

    public void handleDoneBtn(ActionEvent actionEvent) {
        hotelIdsBasedOnArea =new LinkedBlockingQueue<>();
        String str= hotelSearchBox.getText();
      //  System.out.println(str);
        homePageVbox.getChildren().clear();
        for(var hotel:  HelloApplication.allHotels){
            if(str.equals(hotel.get("district"))){
                hotelIdsBasedOnArea.add(hotel);
            }
        }
        for(var hotel: hotelIdsBasedOnArea){
            try{
                showHotels(hotel);}
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public void handleTypeDone(ActionEvent actionEvent) {
        hotelIdsonType=new LinkedBlockingQueue<>();
        String selType = null;
        if (rAFrame.isSelected()) {
            selType = "AFrames";
        }else if(rCabin.isSelected()) {
            selType = "Cabins";
        } else if (rCottage.isSelected()) {
            selType = "Cottage";
        } else if (rVilla.isSelected()) {
            selType = "Villa";
        }

        for (var hotel : hotelIdsBasedOnArea) {
            if (selType.equals(hotel.get("type"))) {
                    hotelIdsonType.add(hotel);
            }
        }

        homePageVbox.getChildren().clear();
        for(var hotel:  hotelIdsonType) {

            try{
                showHotels(hotel);}
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public void showHotels(Map<String,Object> hotel) throws Exception{

        Rectangle smallRectangle = new Rectangle(250, 200);
        homePageVbox.setPadding(new Insets(5));
        smallRectangle.setFill(Color.BLUE);

        StringBuilder str=new StringBuilder();

        str.append("Name: ").append((String) hotel.get("name")).append("\n")
                .append("Address: ").append((String) hotel.get("address")).append("\n")
                .append("Cost Per Night: ").append(hotel.get("costpernight")).append(" BDT").append("\n");
        String data= str.toString();

       // System.out.println(data);
        Label descriptionLabel = new Label(data);
        descriptionLabel.setWrapText(true);
        descriptionLabel.setPrefWidth(250);
        descriptionLabel.setPrefHeight(70);
        descriptionLabel.setStyle("-fx-text-fill: black; -fx-padding: 0;");

        VBox vBox = new VBox();
        vBox.setMinWidth(250);
        vBox.setMinHeight(300);
        vBox.getChildren().addAll(smallRectangle, descriptionLabel);
        vBox.setSpacing(5);



        StackPane stackPane = new StackPane(vBox);
        stackPane.setMinWidth(250);
        stackPane.setMinHeight(300);
        stackPane.setPadding(new Insets(5));

        // Store hotel information in StackPane
        stackPane.setUserData(hotel);

        stackPane.setOnMouseClicked(this::handleRectangleClick);

        HBox f=null;

        int childrenSize = homePageVbox.getChildren().size();
        if(childrenSize==0){
            HBox hB=new HBox();
            hB.setMinHeight(300);
            homePageVbox.getChildren().add(hB);
        }
        else{
             f = (HBox) homePageVbox.getChildren().getLast();
            if (f.getChildren().size() == 4) {
                HBox hB=new HBox();
                hB.setMinHeight(300);
                homePageVbox.getChildren().add(hB);

            }
        }

        HBox hBox = (HBox) homePageVbox.getChildren().getLast();
        hBox.setMinHeight(300);
        hBox.getChildren().add(stackPane);
        homePageVbox.getChildren().remove(homePageVbox.getChildren().getLast());
        homePageVbox.setSpacing(5);
        hBox.setSpacing(5);
        homePageVbox.getChildren().add(hBox);

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for(var hotel:  HelloApplication.allHotels){
            try{
                showHotels(hotel);}
            catch(Exception e){
                e.printStackTrace();
            }
        }
//        File file = null;
//        try {
//            file = DatabaseClient.stringToFile(Account.loggedIn.getProFilePhoto());
//            Image image = new Image(file.toURI().toString());
//            profileChobiEbongButton.setImage(image); // Set image to the existing ImageView instance
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
    }

    public void handleRectangleClick(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("newWindow.fxml"));
            VBox newWindowRoot = fxmlLoader.load();

            Stage newWindowStage = new Stage();
            newWindowStage.setTitle("New Window");
            newWindowStage.setScene(new Scene(newWindowRoot, 400, 300));
            newWindowStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
