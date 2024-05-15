package org.example.Manage;

import java.util.Scanner;

public class HotelSystem {
    public static void main(String args[]) {
        // Scanner scanner = new Scanner(System.in);
        Management management = new Management();
        Area area = management.getAreabyName("Saint Martin");
        Hotel hotel = new Villa("6/D, ABC, Sakail");

        Room room1 = new SingleRoom(10.2 * 9.1);
        room1 = new Balcony(room1);

        Room room2 = new DoubleRoom(12.5 * 12);
        room2 = new AirConditioner(room2);
        room2 = new AttachedBath(room2);

        Room room3 = new LargeRoom(15 * 12);
        room3 = new AttachedBath(room3);
        room3 = new Balcony(room3);
        room3 = new AirConditioner(room3);

        House house = new Facilities();

        house = new Lawn(house);
        house = new Garage(house);
        house = new SwimmingPool(house);
        house = new Kitchen(house);
        hotel.setOtherFacility(house);

        hotel.addRoom(room1);
        hotel.addRoom(room2);
        hotel.addRoom(room3);

        area.addHotel(hotel);

        System.out.println(management.getAreabyName("Saint Martin").getDistrictName());
        System.out.println(management.getAreabyName("Sajek").getDistrictName() + "\n");
        area.vacantHotels("", "");
        System.out.println(area.getHotelOfOneType("Villa").get(0).getAddress() + "\n");

        System.out.println(hotel.getType());
        System.out.println(hotel.getAddress() + "\n");

        System.out.println(hotel.getCostForRooms());
        System.out.println(hotel.getCostForOtherFacilities());
        System.out.println(hotel.getCostPerNight() + "\n");

        System.out.println(hotel.getRoomDetails() + "\n");
        System.out.println(hotel.getHouseDetails() + "\n");
        System.out.println(hotel.getSpecifications());
    }

    public static Hotel createHotel() {
        // int id = scanner.nextInt();
        Hotel hotel = new Villa("6/D, ABC, Sakail");

        Room room1 = new SingleRoom(10.2 * 9.1);
        room1 = new Balcony(room1);

        Room room2 = new DoubleRoom(12.5 * 12);
        room2 = new AirConditioner(room2);
        room2 = new AttachedBath(room2);

        Room room3 = new LargeRoom(15 * 12);
        room3 = new AttachedBath(room3);
        room3 = new Balcony(room3);
        room3 = new AirConditioner(room3);

        House house = new Facilities();
        house = new Kitchen(house);
        house = new Lawn(house);
        house = new Garage(house);
        house = new SwimmingPool(house);

        hotel.setOtherFacility(house);
        hotel.addRoom(room1);
        hotel.addRoom(room2);
        hotel.addRoom(room3);

        return hotel;
    }

    // public static Hotel newHotel(int id) {

    // if (id == 1) {
    // Hotel hotel = new Cabin("6/D, ABC, Sakail");
    // return hotel;
    // }
    // if (id == 2) {
    // Hotel hotel = new Cottage("30/4/D, XYZ, Polashi");
    // return hotel;
    // }
    // if (id == 3) {
    // Hotel hotel = new AFrames("47/6/F, MNO, Lalbagh");
    // return hotel;
    // }
    // return null;
    // }

}
