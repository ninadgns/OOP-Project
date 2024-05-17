package org.example.Manage;

public class Kitchen extends IndoorDecorator {

    public Kitchen(CommonSpace decoIndoorSpace) {
        super(decoIndoorSpace);
     }
    public String getDescription() {
        StringBuilder str = new StringBuilder();
        str.append(super.getDescription()).append(" Kitchen,");

        return str.toString();
    }

    public int getCost() {
        return 90 + super.getCost();
    }
}
