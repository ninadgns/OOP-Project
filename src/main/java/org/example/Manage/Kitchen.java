package org.example.Manage;

import java.util.ArrayList;

public class Kitchen extends IndoorDecorator {

    public Kitchen(CommonSpace decoIndoorSpace) {
        super(decoIndoorSpace);
    }

    public ArrayList<String> getAmenities() {
        var a = new ArrayList<>(super.getAmenities());
        a.add("Kitchen");
        return a;

        // StringBuilder str = new StringBuilder();
        // str.append(super.getDescription()).append(" Kitchen,");
        // return str.toString();

    }

    public int getCost() {
        return 90 + super.getCost();
    }
}
