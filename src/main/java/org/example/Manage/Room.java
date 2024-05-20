package org.example.Manage;

import java.util.ArrayList;

public abstract class Room {
    private String bedSize, description;
    private int allowedPersons, cost;

    // private double sqFt;

    public abstract int getCost();

    // public abstract String getDescription();
    public abstract ArrayList<String> getAmenities();

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setAllowedPerson(int allowedPerson) {
        this.allowedPersons = allowedPerson;
    }

    public int getAllowedPerson() {
        return this.allowedPersons;
    }

    public String getBedSize() {
        return this.bedSize;
    }

    public void setBedSize(String bedSize) {
        this.bedSize = bedSize;
    }

}

abstract class RoomDecorator extends Room {

}
