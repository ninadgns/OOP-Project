package org.example.Manage;

import java.util.ArrayList;

public class Patio extends OutdoorDecorator {
    public Patio(CommonSpace decoOutdoorSpace) {
        super(decoOutdoorSpace);
    }

    public ArrayList<String> getAmenities() {
        var a = new ArrayList<>(super.getAmenities());
        a.add("Patio");
        return a;

        // StringBuilder str = new StringBuilder();
        // str.append(super.getDescription()).append(" Patio,");
        // return str.toString();

    }

    public int getCost() {
        return 80 + super.getCost();
    }
}