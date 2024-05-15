package org.example.Manage;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class Hotel {
    private String address, roomDetails, houseDetails, specifications;
    private HashMap<Client, CheckInandOut> bookings = new HashMap<>();
    private String type;
    private ArrayList<Room> rooms = new ArrayList<>();
    private House house;
    private int costPerNight, costForRooms, costForOtherFacilities;

    public void addBookings(Client client, CheckInandOut checkInandOut) {
        bookings.put(client, checkInandOut);
    }

    public void removeBooking(Client client) {
        bookings.remove(client);
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setOtherFacility(House house) {
        this.house = house;
    }

    public int getCostForRooms() {
        int cost = 0;
        for (int k = 0; k < rooms.size(); k++) {
            cost += rooms.get(k).getCost();
        }

        return this.costForRooms = cost;
    }

    public int getCostForOtherFacilities() {

        this.costForOtherFacilities = this.house.getCost();
        return this.costForOtherFacilities;
    }

    public String getRoomDetails() {
        StringBuilder str = new StringBuilder();
        // String str = "";
        for (int k = 0; k < rooms.size(); k++) {
            Room room = rooms.get(k);
            str.append(k + 1).append(". ")
                    .append(room.getDescription())
                    .append("\n");
        }

        return this.roomDetails = str.toString();
    }

    public String getHouseDetails() {
        this.houseDetails = this.house.getDescription() + " Other Services.\n";
        return this.houseDetails;
    }

    public String getType() {
        return this.type;
    }

    public String getAddress() {
        return this.address;
    }

    public String getSpecifications() {
        StringBuilder str = new StringBuilder();
        str.append(getRoomDetails()).append(getHouseDetails());
        this.specifications = str.toString();
        return this.specifications;
    }

    public int getCostPerNight() {
        this.costPerNight = getCostForOtherFacilities() + getCostForRooms();
        return this.costPerNight;
    }

    public HashMap<Client, CheckInandOut> getBookings() {
        return this.bookings;
    }
}
