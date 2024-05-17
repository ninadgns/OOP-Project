package org.example.Manage;

import java.util.ArrayList;

public class AirConditioner extends RoomDecorator {
    Room room;

    public AirConditioner(Room room) {
        this.room = room;
    }

    public ArrayList<String> getAmenities() {
        var a = new ArrayList<>(room.getAmenities());
        a.add("AC");
        return a;
    }

    // public String getDescription() {
    // StringBuilder str = new StringBuilder();
    // str.append(room.getDescription()).append(", AC");

    // return str.toString();
    // }

    public int getCost() {
        return 200 + room.getCost();
    }
}
