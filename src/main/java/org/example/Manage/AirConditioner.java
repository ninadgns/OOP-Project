package org.example.Manage;

public class AirConditioner extends RoomDecorator {
    Room room;

    public AirConditioner(Room room) {
        this.room = room;
    }

    public String getDescription() {
        StringBuilder str = new StringBuilder();
        str.append(room.getDescription()).append(", AC");

        return str.toString();
    }

    public int getCost() {
        return 200 + room.getCost();
    }
}
