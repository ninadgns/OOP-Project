package org.example.Manage;

public class Lawn extends HouseDecorator {
    House house;

    public Lawn(House house) {
        this.house = house;
    }

    public String getDescription() {
        StringBuilder str = new StringBuilder();
        str.append(house.getDescription()).append(" Lawn,");

        return str.toString();
    }

    public int getCost() {
        return 100 + house.getCost();
    }
}