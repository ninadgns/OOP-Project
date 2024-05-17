package org.example.Manage;

import java.util.*;
import java.util.ArrayList;

public abstract class Hotel {
    public static int lastHotelID;
    private int hotelID;
    private String address;
    private String district;
    private String roomDetails;
    private String comSpaceDetails;
    private String specifications;

    private String additionalDescription;

    private String name;
    private HashMap<Client, CheckInandOut> bookings = new HashMap<>();
    private String type;
    private ArrayList<Room> rooms = new ArrayList<>();
    // private CommonSpace indoorSpace, outdoorSpace;
    private House house;
    private int costPerNight, costForRooms, costForOtherFacilities;

    private double sqft;

    public ArrayList<String> getRoomDescription(int i) {
        if (rooms.size() <= i)
            return null;
        var f = this.rooms.get(i);
        return f.getAmenities();
    }

    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public String getDistrict() {
        return district;
    }

    public ArrayList<String> getOutdoorAmenities() {
        return this.house.outdoorSpace.getAmenities();
    }

    public ArrayList<String> getIndoorAmenities() {
        return this.house.indoorSpace.getAmenities();
    }

    public String getAdditionalDescription() {
        return additionalDescription;
    }

    public void setAdditionalDescription(String additionalDescription) {
        this.additionalDescription = additionalDescription;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFloorSpace() {
        return sqft;
    }

    public void setSqft(double sqft) {
        this.sqft = sqft;
    }

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

    public void setRoomList(ArrayList<Room> rooms) {
        this.rooms = rooms;
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
        this.costForOtherFacilities = this.house.getCost();
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
                    .append(room.getAmenities())
                    .append("\n");
        }
        this.roomDetails = str.toString();
    }

    public String getRoomDetails() {
        writeRoomDetails();
        return this.roomDetails;
    }

    public void writeComSpaceDetails() {
        this.comSpaceDetails = this.house.getAmenities() + " Other Services.\n";
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
        // String[] CheckIn = checkin.split(" ");
        // String[] CheckOut = checkin.split(" ");
        //
        // int chInDay = Integer.parseInt(CheckIn[0]);
        // int chOutDay = Integer.parseInt(CheckOut[0]);
        // int chInMon = Integer.parseInt(CheckIn[1]);
        // int chOutMon = Integer.parseInt(CheckOut[1]);
        // int chInYear = Integer.parseInt(CheckIn[2]);
        // int chOutYear = Integer.parseInt(CheckOut[2]);

        // final String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
        // "Aug", "Sep", "Oct", "Nov", "Dec" };
        int givenCheckinDate = Integer.parseInt(checkin);
        int givenCheckoutDate = Integer.parseInt(checkout);

        boolean vacant = true;

        for (Map.Entry<Client, CheckInandOut> entry : this.getBookings().entrySet()) {
            CheckInandOut booked = entry.getValue();
            if (booked.checkinDate < givenCheckoutDate && booked.checkinDate > givenCheckinDate) {
                // if ((booked.checkinMon == chInMon && booked.checkinDay <= chInDay) ||
                // (booked.checkoutMon == chInMon && booked.checkoutDay > chInDay)) {
                vacant = false;
                break;
            }
            if (booked.checkoutDate < givenCheckoutDate && booked.checkoutDate > givenCheckinDate) {
                vacant = false;
                break;

            }
        }
        return vacant;
    }
}
