package org.example.Manage;

public class AttachedBath extends RoomDecorator {
    Room room;

    public AttachedBath(Room room) {
        this.room = room;
    }

    public String getDescription() {
        StringBuilder str = new StringBuilder();
        str.append(room.getDescription()).append(", Attached Bath");

        return str.toString();
    }

    public int getCost() {
        return 50 + room.getCost();
    }
}
