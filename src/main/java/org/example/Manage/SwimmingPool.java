package org.example.Manage;

public class SwimmingPool extends OutdoorDecorator {
    public SwimmingPool(CommonSpace decoOutdoorSpace) {
        super(decoOutdoorSpace);
    }

    public String getDescription() {
        StringBuilder str = new StringBuilder();
        str.append(super.getDescription()).append(" Swimming Pool,");

        return str.toString();
    }

    public int getCost() {
        return 150 + super.getCost();
    }
}