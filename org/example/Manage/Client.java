package org.example.Manage;

public class Client {
    private String name, emailAddress;
    private int identificationNo, phoneNo;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmailAddress(String email) {
        this.emailAddress = email;
    }

    public void setphoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setNIDNo(int nidNo) {
        this.identificationNo = nidNo;
    }

    public String getName() {
        return this.name;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public int getphoneNo(int phoneNo) {
        return this.phoneNo;
    }

    public int getNIDNo() {
        return this.identificationNo;
    }
}
