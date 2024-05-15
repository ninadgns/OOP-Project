package org.example.Manage;

public class DoubleRoom extends Room {
    DoubleRoom(double sqft) {
        super.setBedSize("Queen Size Bed");
        super.setAllowedPerson(3);
        super.setSQFT(sqft);
    }

    public int getCost() {
        int cost = 250 + (int) (super.getSQFT() * 15);
        return cost;
    }

    public String getDescription() {
        return "Double Room";
    }

}
