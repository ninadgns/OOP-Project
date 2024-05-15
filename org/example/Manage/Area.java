package org.example.Manage;

import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Area {
    private String districtName;
    private ArrayList<Hotel> hotelLists;
    private ArrayList<Hotel> vacantHotelList;
    private ArrayList<Hotel> hotelListOfOneType;

    Area(String districtName) {
        this.districtName = districtName;
        this.hotelLists = new ArrayList<>();
    }

    public void addHotel(Hotel hotel) {
        hotelLists.add(hotel);
    }

    public String getDistrictName() {
        return this.districtName;
    }

    public ArrayList<Hotel> getVacantHotelList() {
        return this.vacantHotelList;
    }

    public ArrayList<Hotel> getHotelListOfOneType() {
        return this.hotelListOfOneType;
    }

    public ArrayList<Hotel> vacantHotels(String checkin, String checkout) {

        if (checkin.isEmpty() || checkout.isEmpty()
                || !checkin.matches("\\d{2} \\b[a-zA-Z]{3}+ \\d{4}")
                || !checkout.matches("\\d{2} \\b[a-zA-Z]{3}+ \\d{4}")) {
            this.vacantHotelList = this.hotelLists;
            return getVacantHotelList();
        }
        this.vacantHotelList = new ArrayList<>();
        String[] CheckIn = checkin.split(" ");
        String[] CheckOut = checkin.split(" ");
        int chInDay = Integer.parseInt(CheckIn[0]);
        int chOutDay = Integer.parseInt(CheckOut[0]);
        int chInMon = -1, chOutMon = -1;

        final String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
                "Aug", "Sep", "Oct", "Nov", "Dec" };

        for (int i = 0; i < months.length; i++) {
            if (CheckIn[1].equals(months[i])) {
                chInMon = i;
            }
            if (CheckOut[1].equals(months[i])) {
                chOutMon = i;
            }
        }
        for (int k = 0; k < hotelLists.size(); k++) {
            boolean vacant = true;
            Hotel hotel = hotelLists.get(k);
            if (hotel != null) {
                for (Map.Entry<Client, CheckInandOut> entry : hotel.getBookings().entrySet()) {
                    CheckInandOut booked = entry.getValue();

                    if ((booked.checkinMon == chInMon && booked.checkinDay <= chInDay) ||
                            (booked.checkoutMon == chInMon && booked.checkoutDay > chInDay)) {
                        vacant = false;
                        break;
                    }
                    if ((booked.checkinMon == chOutMon && booked.checkinDay < chOutDay) ||
                            (booked.checkoutMon == chOutMon && booked.checkoutDay >= chOutDay)) {
                        vacant = false;
                        break;
                    }
                }

                if (vacant) {
                    this.vacantHotelList.add(hotel);
                }
            }
        }

        return getVacantHotelList();
    }

    public ArrayList<Hotel> getHotelOfOneType(String type) {

        this.hotelListOfOneType = new ArrayList<>();
        for (int k = 0; k < vacantHotelList.size(); k++) {
            Hotel hotel = vacantHotelList.get(k);
            if (hotel.getType().equals(type)) {
                hotelListOfOneType.add(vacantHotelList.get(k));
            }
        }
        return getHotelListOfOneType();
    }

}
