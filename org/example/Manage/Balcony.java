package org.example.Manage;

public class Balcony extends RoomDecorator {
    Room room;

    public Balcony(Room room) {
        this.room = room;
    }

    public String getDescription() {
        StringBuilder str = new StringBuilder();
        str.append(room.getDescription()).append(", Balcony");

        return str.toString();
    }

    public int getCost() {
        return 40 + room.getCost();
    }
}