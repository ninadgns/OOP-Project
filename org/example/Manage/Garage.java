package org.example.Manage;

public class Garage extends OutdoorDecorator {
    public Garage(CommonSpace decoOutdoorSpace) {
        super(decoOutdoorSpace);
    }

    public String getDescription() {
        StringBuilder str = new StringBuilder();
        str.append(super.getDescription()).append(" Car Parking,");

        return str.toString();
    }

    public int getCost() {
        return 90 + super.getCost();
    }
}
