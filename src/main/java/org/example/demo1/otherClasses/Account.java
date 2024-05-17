package org.example.demo1.otherClasses;

import javafx.event.ActionEvent;
import org.example.Manage.Hotel;
import org.example.Manage.Room;
import org.example.database.DatabaseClient;
import org.example.database.Tables;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Account {
    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setCustomer(boolean customer) {
        isCustomer = customer;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setProFilePhoto(String proFilePhoto) {
        this.proFilePhoto = proFilePhoto;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    String fname;
    String lname;
    String name;

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public boolean getIsCustomer() {
        return isCustomer;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getProFilePhoto() {
        return proFilePhoto;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }
    private String fullName;
    private boolean isCustomer;
    private String dateOfBirth;
    private String proFilePhoto;
    private String phoneNumber;
    private String email;
    private String address;
    private String password;
    public static Account loggedIn = new Account();
    public static Hotel hotel;
    public static ArrayList<Room> rooms = new ArrayList<>();

    public static void dbTeAccountPathai(Account account, String DbName, ActionEvent actionEvent) throws IOException {
        String allInfoTogether = "'" + account.getFullName() + "'" + ", " + "'" + account.getPhoneNumber() + "'" + ", "
                + "'" + account.getEmail() + "'" + ", " + "'Ami Address'" + ", " + "'" + account.getPassword() + "'"
                + ", " + "'" + account.getDateOfBirth() + "'" + ", " + "'" + account.getIsCustomer() + "'" + ", " + "'"
                + account.getProFilePhoto() + "'";
        DatabaseClient.insert(DbName, "name, phoneno, email, address, password, dateofbirth, iscustomer, profilephoto",
                allInfoTogether);
        // DatabaseClient.update("notes", "id, content", "5, 'o ma fagune tor'");
        System.out.println("Push Hoise");

    }

    public static void reTrieveAccount(Map<String, Object> f) throws IOException {
        loggedIn.setFullName(f.get("name").toString());
        loggedIn.setEmail(f.get("email").toString());
        loggedIn.setAddress(f.get("address").toString());
        loggedIn.setPassword(f.get("password").toString());
        loggedIn.setPhoneNumber(f.get("phoneno").toString());
        loggedIn.setDateOfBirth(f.get("dateofbirth").toString());
        loggedIn.setCustomer(f.get("iscustomer").toString().equals("true"));
        loggedIn.setProFilePhoto(f.get("profilephoto").toString());
    }

    public static void dbTeHotelPathai() {
        for (Room room : rooms) {
            var facilities = new ArrayList<String>(room.getAmenities().subList(3, room.getAmenities().size()))
                    .toString();
            List<String> list = Arrays.asList(
                    String.valueOf(Hotel.lastHotelID),

                    room.getAmenities().get(0),
                    // room.getAmenities().get(1),
                    // room.getAmenities().get(2),
                    facilities.toString());
            String allInfoTogether = "'" + String.join("', '", list) + "'";
            System.out.println(allInfoTogether);
            DatabaseClient.insert(Tables.ROOMS, "hotelid, type, amenities", allInfoTogether);
        }
        List<String> list = Arrays.asList(
                String.valueOf(Hotel.lastHotelID),
                hotel.getType(),
                hotel.getName(),
                hotel.getAddress(),
                hotel.getDistrict(),
                String.valueOf(hotel.getFloorSpace()),
                String.valueOf(hotel.getCostPerNight()),
                hotel.getAdditionalDescription(),
                "sobinai",
                "sobinai",
                "sobinai",
                "sobinai");

        String allInfoTogether = "'" + String.join("', '", list) + "'";
        System.out.println(allInfoTogether);

        // String allInfoTogether = "'" + Hotel.lastHotelID + "', '" + hotel.getType() +
        // "', '" + hotel.getName() + "', '"
        // + hotel.getAddress() + "', '"
        // + hotel.getDistrict() + "', '" + hotel.getFloorSpace() + "', '" +
        // hotel.getCostPerNight() + "', '"
        // + hotel.getAdditionalDescription() + "', '" + "sobinai" + "', '"
        // + "sobinai" + "', '" + "sobinai" + "', '" + "sobinai'";

        DatabaseClient.insert("hotels",
                "id, type, name, address, district, floorspace, costpernight, additionaldescription, image1, image2, image3, image4",
                allInfoTogether);
        // DatabaseClient.insert("hotels",
        // "id, type, name, address, district, sqft, pernightcost, indoorspace,
        // outdoorspace, additionaldescription, room1, room2, room3, image1, image2,
        // image3, image4 ", allInfoTogether);

    }

}
