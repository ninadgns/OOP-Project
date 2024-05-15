package org.example.Manage;

public class Kitchen extends HouseDecorator {
    House house;

    public Kitchen(House house) {
        this.house = house;
    }

    public String getDescription() {
        StringBuilder str = new StringBuilder();
        str.append(house.getDescription()).append(" Kitchen and Dining Space,");

        return str.toString();
    }

    public int getCost() {
        return 90 + house.getCost();
    }
}
