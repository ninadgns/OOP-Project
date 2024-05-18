package org.example.Manage;

import java.util.ArrayList;

public class Balcony extends RoomDecorator {
    Room room;

    public Balcony(Room room) {
        this.room = room;
    }

    public ArrayList<String> getAmenities() {
        var a = new ArrayList<>(room.getAmenities());
        a.add("Balcony");
        return a;
    }

    // public String getDescription() {
    //     StringBuilder str = new StringBuilder();
    //     str.append(room.getDescription()).append(", Balcony");

    //     return str.toString();
    // }

    public int getCost() {
        return 40 + room.getCost();
    }
}