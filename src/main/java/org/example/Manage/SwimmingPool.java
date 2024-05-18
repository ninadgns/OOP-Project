package org.example.Manage;

import java.util.ArrayList;

public class SwimmingPool extends OutdoorDecorator {
    public SwimmingPool(CommonSpace decoOutdoorSpace) {
        super(decoOutdoorSpace);
    }

    public ArrayList<String> getAmenities() {
        var a = new ArrayList<>(super.getAmenities());
        a.add("Swimming Pool");
        return a;

        // StringBuilder str = new StringBuilder();
        // str.append(super.getDescription()).append(" Swimming Pool,");
        // return str.toString();

    }

    public int getCost() {
        return 150 + super.getCost();
    }
}