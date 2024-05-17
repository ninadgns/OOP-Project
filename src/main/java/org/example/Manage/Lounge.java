package org.example.Manage;

import java.util.ArrayList;

public class Lounge extends IndoorDecorator {

    public Lounge(CommonSpace decoIndoorSpace) {
        super(decoIndoorSpace);
     }
     
    public ArrayList<String> getAmenities() {
        var a = new ArrayList<>(super.getAmenities());
        a.add("Lounge");
        return a;

        // StringBuilder str = new StringBuilder();
        // str.append(super.getDescription()).append(" Kitchen,");
        // return str.toString();

    }

    public int getCost() {
        return 70 + super.getCost();
    }
}