package org.example.Manage;

public class Dining extends IndoorDecorator {

    public Dining(CommonSpace decoIndoorSpace) {
        super(decoIndoorSpace);
    }
    public String getDescription() {
        StringBuilder str = new StringBuilder();
        str.append(super.getDescription()).append(" Dining Space,");

        return str.toString();
    }

    public int getCost() {
        return 90 + super.getCost();
    }
}