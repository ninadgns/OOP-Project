package org.example.Manage;

public class SwimmingPool extends HouseDecorator {
    House house;

    public SwimmingPool(House house) {
        this.house = house;
    }

    public String getDescription() {
        StringBuilder str = new StringBuilder();
        str.append(house.getDescription()).append(" Swimming Pool,");

        return str.toString();
    }

    public int getCost() {
        return 150 + house.getCost();
    }
}