package org.example.Manage;

public class SingleRoom extends Room {

    SingleRoom(double sqft) {
        super.setBedSize("Single Bed");
        super.setAllowedPerson(1);
        super.setSQFT(sqft);
    }

    public int getCost() {
        int cost = 150 + (int) (super.getSQFT() * 15);
        return cost;
    }

    public String getDescription() {
        return "Single Room";
    }

}