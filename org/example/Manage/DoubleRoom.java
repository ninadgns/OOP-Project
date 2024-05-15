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
        StringBuilder str = new StringBuilder();
        str.append("Double Room (").append(super.getBedSize())
                .append(",Allowed Persons ")
                .append(getAllowedPerson()).append(", ")
                .append(super.getSQFT()).append(" sqft").append(")");
        return str.toString();
    }

}
