package org.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import org.example.Manage.CheckInandOut;
import org.example.Manage.Client;
import org.example.Manage.Hotel;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.database.DatabaseClient;
import org.example.demo1.otherClasses.Account;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.example.Manage.CheckInandOut;
import org.example.demo1.otherClasses.Account;
import java.time.LocalDate;
public class hotelClickedController implements Initializable {
    public ImageView amiLogo;
    public static CheckInandOut newbooking;
    public static String costPerNight,hotelID,customerID;
    @FXML
    public Label total;
    @FXML
    public Label takaa;
    @FXML
    public Label kata;
    @FXML
    public Label taka;
    private BlockingQueue<Map<String,Object>> bookingsDone;
    private List<Map<String,Object>>  allBooking;
    @FXML
    public Button reserve;
    @FXML
    public HBox imageVbox;

    @FXML
    public DatePicker checkIn;
    @FXML
    public DatePicker checkOut;
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
    public int totalPrice;
    String day;
    boolean isPossible = false;
Account host;
    public void handleChatManager(MouseEvent mouseEvent) {
        DatabaseClient.insertMessage(Account.loggedIn.id, host.getId(), "Hi");

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("telegram.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            // stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //handleReserveBtn
    public void handleReserveBtn(ActionEvent event) {
        handleCalculate(event);

        if(!isPossible){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Set Dates Properly");
            alert.showAndWait();
        }
        Account.dbTeBookingPathai(newbooking,hotelID,customerID,day,Integer.toString(totalPrice));
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Booking Done");
        alert.setHeaderText("Your total payment");
        alert.setContentText(Integer.toString(totalPrice));
        alert.showAndWait();
    }


    public void getPreviousBooking(){
        allBooking=DatabaseClient.fetch("bookings");
        bookingsDone=new LinkedBlockingQueue<>();

        for(var booking: allBooking){
            if(booking.get("hotel_id").toString().equals(hotelID)){
                bookingsDone.add(booking);
            }
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public boolean isVacant(String checkin, String checkout) {

        if (checkin.isEmpty() || checkout.isEmpty()
                || !checkin.matches("\\d{4}\\d{2}\\d{2}")
                || !checkout.matches("\\d{4}\\d{2}\\d{2}")) {
            return true;
        }

        int givenCheckinDate = Integer.parseInt(checkin);
        int givenCheckoutDate = Integer.parseInt(checkout);
        System.out.println(givenCheckoutDate +" " + givenCheckinDate);
        boolean vacant = true;

        if(!bookingsDone.isEmpty()) {
            for (var booking : bookingsDone) {
                int bookedDate1 = Integer.parseInt(booking.get("check_in_date").toString());
                int bookedDate2 = Integer.parseInt(booking.get("check_out_date").toString());
                // System.out.println("3. "+bookedDate2 +" " + bookedDate1);
                if (bookedDate1 < givenCheckoutDate && bookedDate2 > givenCheckinDate) {
                    vacant = false;
                    break;
                }
                if (bookedDate2 < givenCheckoutDate && bookedDate1 > givenCheckinDate) {
                    vacant = false;
                    break;

                }
            }
        }
        return vacant;
    }
    public void setHotelData(Map<String, Object> hotel, String hotelId) throws IOException {
        hotelID=hotelId;
        hotelName.setText(hotel.get("name").toString());
        type.setText(hotel.get("type").toString());
        outdoor.setText(hotel.get("outdoorspace").toString());
        indoor.setText(hotel.get("indoorspace").toString());
        address.setText(hotel.get("address").toString());
        additionDescription.setText(hotel.get("additionaldescription").toString());
        costPerNight=hotel.get("costpernight").toString();
        System.out.println(costPerNight);
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
            host = Account.reTrieveAccount(row);
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

    public void handleCalculate(ActionEvent actionEvent) {

        LocalDate checkInDate =checkIn.getValue();
        LocalDate checkOutDate =checkOut.getValue();
        customerID=Account.loggedIn.getId();
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formattedDate = currentDate.format(formatter);

        getPreviousBooking();

        if (checkInDate != null && checkOutDate != null) {
            // Format the date
            DateTimeFormatter Informatter = DateTimeFormatter.ofPattern("yyyyMMdd");
            String InformattedDate = checkInDate.format(Informatter);
            DateTimeFormatter Outformatter = DateTimeFormatter.ofPattern("yyyyMMdd");
            String OutformattedDate = checkOutDate.format(Outformatter);
            int c = Integer.parseInt(formattedDate);
            int a =Integer.parseInt(InformattedDate);
            int b =Integer.parseInt(OutformattedDate);

            if(a>b || a<=c || b<=c){
                //System.out.println("1. "+a+" "+b);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Alert");
                alert.setHeaderText("Select check-in and check-out date properly");
                //alert.setContentText(formattedDate);
                alert.showAndWait();
                return;

            }
            newbooking=new CheckInandOut(InformattedDate,OutformattedDate);
            boolean vacant= isVacant(InformattedDate,OutformattedDate);
            if(vacant){

                int days = newbooking.getTotalDays();
                 day= Integer.toString(days);
                int totalCost=days*(int)Integer.parseInt(costPerNight) +150;
                // System.out.println("2. "+Integer.parseInt(day) +" " + Integer.parseInt(costPerNight)  +" " + days+" " + costPerNight);
                totalPrice= (totalCost)-150;
                isPossible=true;
//                return;
                //bookingsDone.add(booking);
            }
            else{
                //System.out.println(formattedDate);
                // Show the formatted date in an alert dialog
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Alert");
                alert.setHeaderText("Your selected dates are booked already");
                //alert.setContentText(formattedDate);
                alert.showAndWait();}
        } else {
            // If no date is selected, show an alert
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Date Selected");
            alert.setHeaderText("No date selected");
            alert.setContentText("Please select dates for check-in and check-out");
            alert.showAndWait();
        }

//        kata.setText(Integer.toString((int)(totalPrice+totalPrice/10)));
        taka.setText(Integer.toString((int)(totalPrice)));
        takaa.setText(Integer.toString((int)(totalPrice)));
        total.setText(Integer.toString((int)(totalPrice+150)));
//        kata.setText(;

    }
}
