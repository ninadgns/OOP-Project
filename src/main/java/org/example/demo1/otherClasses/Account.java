package org.example.demo1.otherClasses;

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

    public boolean isCustomer() {
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

    String fullName;
    boolean isCustomer;
    String dateOfBirth;
    String proFilePhoto;
    String phoneNumber;
    String email;
    String address;
    String password;

}
