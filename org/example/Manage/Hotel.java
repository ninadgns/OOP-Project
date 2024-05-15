package org.example.Manage;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
public abstract class Hotel {
    private String address, roomDetails, houseDetails;
    // private boolean vacant;
    private HashMap<CheckInandOut, Client> bookings = new HashMap<>();
    private String type;
    private ArrayList<Room> rooms;
    private House house;
    private int costPerNight, costForRooms,costForOtherFacilities;

    public HashMap<CheckInandOut, Client> getBookings() {
        return this.bookings;
    }

    public void addBookings(CheckInandOut checkInandOut, Client client) {
        bookings.put(checkInandOut, client);
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public int getCostForRooms() {
        StringBuilder str=new StringBuilder();
        for (int k = 0; k < rooms.size(); k++) {
            this.costForRooms+=rooms.get(k).getCost();
            str.append(k+1).append(". ").append(rooms.get(k).getDescription()).append("\n");
        }
        this.houseDetails=str.toString();
       return this.costForRooms;
    }
    public int getCostForOtherFacilities() {
        this.houseDetails=this.house.getDescription();
        this.costForOtherFacilities=this.house.getCost();
       return this.costForOtherFacilities;
    }

    public String getRoomDetails() {
        return this.roomDetails;
    }
    public String getHouseDetails() {
        this.houseDetails+=" Other Services.\n";
        return this.houseDetails;
    }

    public int getCostPerNight() {
        this.costPerNight=getCostForOtherFacilities()+ getCostForRooms();
        return this.costPerNight;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public void setOtherFacility(House house) {
        this.house = house;
    }

}
