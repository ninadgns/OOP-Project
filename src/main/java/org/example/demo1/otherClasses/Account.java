package org.example.demo1.otherClasses;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.database.DatabaseClient;

import java.io.IOException;

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
    private Account loggedIn;
    public static void dbTeAccountPathai(Account account, String DbName, ActionEvent actionEvent) throws IOException {
        String allInfoTogether =  "'"+account.getFullName()+"'"+", "+"'"+account.getPhoneNumber()+"'"+", "+"'"+account.getEmail()+"'"+", "+"'Ami Address'"+", "+"'"+account.getPassword()+"'"+", "+"'"+account.getDateOfBirth()+"'"+", "+"'"+account.getIsCustomer()+"'"+", 'Ami Sobi'";
        DatabaseClient.insert(DbName, "name, phoneno, email, address, password, dateofbirth, iscustomer, profilephoto", allInfoTogether);
//        DatabaseClient.update("notes", "id, content", "5, 'o ma fagune tor'");
        System.out.println("Push Hoise");

    }
}

