package org.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.example.Manage.AFrames;
import org.example.Manage.Cabin;
import org.example.Manage.Cottage;
import org.example.Manage.Villa;
import org.example.database.DatabaseClient;
import org.example.demo1.otherClasses.Account;

import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;

public class HomePageForCustomerController implements Initializable {
//    HomePageForCustomerController(){
//        super();
//    }
    public Label emneiLabel;
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
        // Filter hotels based on selected type
      //  if (selType != null) {
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
        Rectangle rectangle = new Rectangle(200, 200);
        homePageVbox.setPadding(new Insets(5));
        rectangle.setFill(Color.BLUE);


        String description = (String) hotel.get("name");
       // System.out.println(description);
        Label descriptionLabel = new Label(description);
        descriptionLabel.setWrapText(true);
        descriptionLabel.setStyle("-fx-text-fill: white; -fx-padding: 10px;");

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(rectangle, descriptionLabel);

        HBox f=null;

        int childrenSize = homePageVbox.getChildren().size();
        if(childrenSize==0){
            homePageVbox.getChildren().add(new HBox());
        }
        else{
             f = (HBox) homePageVbox.getChildren().getLast();
            if (f.getChildren().size() == 4) {
                homePageVbox.getChildren().add(new HBox());
            }
        }


        HBox hBox = (HBox) homePageVbox.getChildren().getLast();
       //     hBox.getChildren().add(rectangle);
        hBox.getChildren().add(stackPane);
        homePageVbox.getChildren().remove(homePageVbox.getChildren().getLast());
   //        homePageVbox.(new Insets(5));
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


}
