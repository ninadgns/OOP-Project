package org.example.Manage;

import java.util.ArrayList;

public class Yard extends OutdoorDecorator {
    public Yard(CommonSpace decoOutdoorSpace) {
        super(decoOutdoorSpace);
    }

    public ArrayList<String> getAmenities() {
        var a = new ArrayList<>(super.getAmenities());
        a.add("Yard");
        return a;

        // StringBuilder str = new StringBuilder();
        // str.append(super.getDescription()).append(" Lawn,");
        // return str.toString();

    }

    public int getCost() {
        return 100 + super.getCost();
    }
}