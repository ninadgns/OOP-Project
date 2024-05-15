package org.example.Manage;

public class LargeRoom extends Room {
    LargeRoom(double sqft) {
        super.setBedSize("King Size Bed");
        super.setAllowedPerson(4);
        super.setSQFT(sqft);
    }

    public int getCost() {
        int cost = 400 + (int) (super.getSQFT() * 15);
        return cost;
    }

    public String getDescription() {
        return "Large Room";
    }

}
