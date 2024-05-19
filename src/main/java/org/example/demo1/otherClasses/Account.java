package org.example.demo1.otherClasses;

import javafx.event.ActionEvent;
import org.example.Manage.CheckInandOut;
import org.example.Manage.Hotel;
import org.example.Manage.Room;
import org.example.database.DatabaseClient;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Account {
    private String fname;
    private String lname;
    private String name;
    public String id;
    private String fullName;
    private boolean isCustomer;
    private String dateOfBirth;
    private String proFilePhoto;
    private String phoneNumber;
    private String email;
    private String address;
    private String password;
    public static File image1=null;
    public static File image2=null;
    public static File image3=null;
    public static File image4=null;

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
        loggedIn.setId(f.get("id").toString());
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
            var facilities = new ArrayList<String>(room.getAmenities().subList(3, room.getAmenities().size()));
            String result = "'" + String.join("', '", facilities) + "'";

            try {
                DatabaseClient.conn.createStatement()
                        .executeUpdate("insert into rooms (hotelid, type, amenities) values (" + Hotel.lastHotelID
                                + ", '" + room.getAmenities().get(0) + "', ARRAY[" + result + "])");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String str1="sobinai",str2="sobinai",str3="sobinai",str4="sobinai";
        if(image1!=null){
        try{
            str1=DatabaseClient.fileToString(image1);}
        catch(Exception e) {
            e.printStackTrace();
        }
        }
        if(image2!=null){
            try{
                str2=DatabaseClient.fileToString(image2);}
            catch(Exception e) {
                e.printStackTrace();
            }
        }
        if(image3!=null){
            try{
                str3=DatabaseClient.fileToString(image3);}
            catch(Exception e) {
                e.printStackTrace();
            }
        }
        if(image4!=null){
            try{
                str4=DatabaseClient.fileToString(image4);}
            catch(Exception e) {
                e.printStackTrace();
            }
        }
       // String toString(hotel.getCostPerNight());
        //System.out.println(str1);
        List<String> list = Arrays.asList(

                String.valueOf(Hotel.lastHotelID),
//                loggedIn.getId(),
                hotel.getType(),
                hotel.getName(),
                hotel.getAddress(),
                hotel.getDistrict(),
                '"' + String.join("\",\"", hotel.getIndoorAmenities()) + '"',
                '"' + String.join("\",\"", hotel.getOutdoorAmenities()) + '"',
                hotel.getAdditionalDescription(),
                str1,
                str2,
                str3,
                str4,
                String.valueOf(hotel.getFloorSpace()),
                String.valueOf(hotel.getCostPerNight()),
                loggedIn.getId());

        String allInfoTogether = "'" + String.join("', '", list) + "'";
        System.out.println(allInfoTogether);

        // String allInfoTogether = "'" + Hotel.lastHotelID + "', '" + hotel.getType() +
        // "', '" + hotel.getName() + "', '"
        // + hotel.getAddress() + "', '"
        // + hotel.getDistrict() + "', '" + hotel.getFloorSpace() + "', '" +
        // hotel.getCostPerNight() + "', '"
        // + hotel.getAdditionalDescription() + "', '" + "sobinai" + "', '"
        // + "sobinai" + "', '" + "sobinai" + "', '" + "sobinai'";
        int i=0;
       // String s= toString(hotel.getFloorSpace());
        DatabaseClient.insert("hotels",
                "id, type, name, address, district, indoorspace, outdoorspace, additionaldescription, image1, image2, image3, image4, floorspace, costpernight, ownerid",
                allInfoTogether);
        // DatabaseClient.insert("hotels",
        // "id, type, name, address, district, sqft, pernightcost, indoorspace,
        // outdoorspace, additionaldescription, room1, room2, room3, image1, image2,
        // image3, image4 ", allInfoTogether);

        image1=null;
        image2=null;
        image3=null;
        image4=null;

    }

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}