package org.example.Manage;

import java.util.ArrayList;

public class Garage extends OutdoorDecorator {
    public Garage(CommonSpace decoOutdoorSpace) {
        super(decoOutdoorSpace);
    }

    public ArrayList<String> getAmenities() {
        var a = new ArrayList<>(super.getAmenities());
        a.add("Garage");
        return a;

        // StringBuilder str = new StringBuilder();
        // str.append(super.getDescription()).append(" Garage,");
        // return str.toString();

    }

    public int getCost() {
        return 90 + super.getCost();
    }
}
