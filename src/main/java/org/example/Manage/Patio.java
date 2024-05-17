package org.example.Manage;

public class Patio extends OutdoorDecorator {
    public Patio(CommonSpace decoOutdoorSpace) {
        super(decoOutdoorSpace);
    }

    public String getDescription() {
        StringBuilder str = new StringBuilder();
        str.append(super.getDescription()).append(" Patio,");

        return str.toString();
    }

    public int getCost() {
        return 80 + super.getCost();
    }
}
