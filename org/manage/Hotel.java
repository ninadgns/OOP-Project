package org.manage;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
public abstract class Hotel {
    private String address;
    // private boolean vacant;
    private HashMap<CheckInandOut, Client> bookings = new HashMap<>();
    private String type;
    private ArrayList<Room> rooms;
    private OtherFacilities others;
    private int costPerNight;

    public HashMap<CheckInandOut, Client> getBookings() {
        return this.bookings;
    }

    public void addBookings(CheckInandOut checkInandOut, Client client) {
        bookings.put(checkInandOut, client);
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public int getcostPerNight() {
        return this.costPerNight;
    }

    public void setcostPerNight(int costPerNight) {
        this.costPerNight = costPerNight;
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

    // public void setVacancy(boolean vacant) {
    // this.vacant = vacant;
    // }

    // public boolean getVacancy() {
    // return this.vacant;
    // }

    public void setOtherFacility(OtherFacilities others) {
        this.others = others;
    }

}
