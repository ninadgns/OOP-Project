package org.example.Manage;

import java.util.ArrayList;

public class AttachedBath extends RoomDecorator {
    Room room;

    public AttachedBath(Room room) {
        this.room = room;
    }
    public ArrayList<String> getAmenities() {
        var a = new ArrayList<>(room.getAmenities());
        a.add("Attached Bath");
        return a;
    }
    // public String getDescription() {
    //     StringBuilder str = new StringBuilder();
    //     str.append(room.getDescription()).append(", Attached Bath");

    //     return str.toString();
    // }

    public int getCost() {
        return 50 + room.getCost();
    }
}
