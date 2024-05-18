package org.example.Manage;

import java.util.ArrayList;

public class Dining extends IndoorDecorator {

    public Dining(CommonSpace decoIndoorSpace) {
        super(decoIndoorSpace);
    }

    public ArrayList<String> getAmenities() {
        var a = new ArrayList<>(super.getAmenities());
        a.add("Dining Space");
        return a;

        // StringBuilder str = new StringBuilder();
        // str.append(super.getDescription()).append(" Dining Space,");
        // return str.toString();

    }

    public int getCost() {
        return 90 + super.getCost();
    }
}