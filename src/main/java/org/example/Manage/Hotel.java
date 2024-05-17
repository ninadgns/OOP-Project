package org.example.Manage;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class Hotel {
    private String address, roomDetails, comSpaceDetails, specifications;
    private HashMap<Client, CheckInandOut> bookings = new HashMap<>();
    private String type;
    private ArrayList<Room> rooms = new ArrayList<>();
    private CommonSpace commonSpace;
    private double sqft;

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

    public void setOtherFacility(CommonSpace commonSpace) {
        this.commonSpace =commonSpace;
    }

    public void calculateCostForRooms() {
        int cost = 0;
        for (int k = 0; k < rooms.size(); k++) {
            cost += rooms.get(k).getCost();
        }
        this.costForRooms = cost;
    }
    public int getCostForRooms() {
        calculateCostForRooms();
        return this.costForRooms;
    }

    public void calculateCostForOtherFacilities() {
        this.costForOtherFacilities = this.commonSpace.getCost();
    }

    public int getCostForOtherFacilities() {
        calculateCostForOtherFacilities();
        return this.costForOtherFacilities;
    }

    public void writeRoomDetails() {
        StringBuilder str = new StringBuilder();
        // String str = "";
        for (int k = 0; k < rooms.size(); k++) {
            Room room = rooms.get(k);
            str.append(k + 1).append(". ")
                    .append(room.getDescription())
                    .append("\n");
        }
        this.roomDetails = str.toString();
    }

    public String getRoomDetails() {
        writeRoomDetails();
        return this.roomDetails;
    }

    public void writeComSpaceDetails() {
        this.comSpaceDetails = this.commonSpace.getDescription() + " Other Services.\n";

    }
    public String getComSpaceDetails() {
        writeComSpaceDetails();
        return this.comSpaceDetails;
    }

    public String getType() {
        return this.type;
    }

    public String getAddress() {
        return this.address;
    }

    public String getSpecifications() {
        StringBuilder str = new StringBuilder();
        str.append(getRoomDetails()).append(getComSpaceDetails());
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


    public boolean vacantHotels(String checkin, String checkout) {

        if (checkin.isEmpty() || checkout.isEmpty()
                || !checkin.matches("\\d{4}\\d{2}\\d{2}")
                || !checkout.matches("\\d{4}\\d{2}\\d{2}")) {
            return true;
        }
//        String[] CheckIn = checkin.split(" ");
//        String[] CheckOut = checkin.split(" ");
//
//        int chInDay = Integer.parseInt(CheckIn[0]);
//        int chOutDay = Integer.parseInt(CheckOut[0]);
//        int chInMon = Integer.parseInt(CheckIn[1]);
//        int chOutMon = Integer.parseInt(CheckOut[1]);
//        int chInYear = Integer.parseInt(CheckIn[2]);
//        int chOutYear = Integer.parseInt(CheckOut[2]);


//        final String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
//                "Aug", "Sep", "Oct", "Nov", "Dec" };
        int givenCheckinDate = Integer.parseInt(checkin);
        int givenCheckoutDate = Integer.parseInt(checkout);

        boolean vacant = true;

        for (Map.Entry<Client, CheckInandOut> entry : this.getBookings().entrySet()) {
            CheckInandOut booked = entry.getValue();
            if(booked.checkinDate < givenCheckoutDate && booked.checkinDate > givenCheckinDate){
//               if ((booked.checkinMon == chInMon && booked.checkinDay <= chInDay) ||
//                    (booked.checkoutMon == chInMon && booked.checkoutDay > chInDay)) {
                 vacant = false;
                 break;
            }
            if(booked.checkoutDate < givenCheckoutDate && booked.checkoutDate > givenCheckinDate){
               vacant = false;
                 break;

            }
        }
        return vacant;
    }
}
