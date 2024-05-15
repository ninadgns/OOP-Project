package org.example.Manage;

public abstract class House {
    private String description;
    private int cost;

    public abstract String getDescription();

    public abstract int getCost();

}

class Facilities extends House {
    public String getDescription() {
        return "Facilities:";
    }

    public int getCost() {
        return 60;
    }
}

abstract class HouseDecorator extends House {

}