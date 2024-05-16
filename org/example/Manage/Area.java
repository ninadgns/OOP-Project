package org.example.Manage;

import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Area {
    private String districtName;
    private ArrayList<Hotel> hotelLists;
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

    public ArrayList<Hotel> getHotelListOfOneType() {
        return this.hotelListOfOneType;
    }

    public ArrayList<Hotel> getHotelOfOneType(String type) {

        this.hotelListOfOneType = new ArrayList<>();
        for (int k = 0; k < hotelLists.size(); k++) {
            Hotel hotel = hotelLists.get(k);
            if (hotel.getType().equals(type)) {
                hotelListOfOneType.add(hotelLists.get(k));
            }
        }
        return getHotelListOfOneType();
    }

}
