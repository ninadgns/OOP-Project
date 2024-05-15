package org.example.Manage;

public class Garage extends HouseDecorator {
    House house;

    public Garage(House house) {
        this.house = house;
    }

    public String getDescription() {
        StringBuilder str = new StringBuilder();
        str.append(house.getDescription()).append(" Car Parking,");

        return str.toString();
    }

    public int getCost() {
        return 90 + house.getCost();
    }
}
