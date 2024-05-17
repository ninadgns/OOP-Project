package org.example.Manage;

public class Yard extends OutdoorDecorator {
    public Yard(CommonSpace decoOutdoorSpace) {
        super(decoOutdoorSpace);
    }

    public String getDescription() {
        StringBuilder str = new StringBuilder();
        str.append(super.getDescription()).append(" Lawn,");

        return str.toString();
    }

    public int getCost() {
        return 100 + super.getCost();
    }
}