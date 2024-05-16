package org.example.Manage;

public class Lounge extends IndoorDecorator {

    public Lounge(CommonSpace decoIndoorSpace) {
        super(decoIndoorSpace);
     }
     
    public String getDescription() {
        StringBuilder str = new StringBuilder();
        str.append(super.getDescription()).append(" Lounge,");

        return str.toString();
    }

    public int getCost() {
        return 70 + super.getCost();
    }
}