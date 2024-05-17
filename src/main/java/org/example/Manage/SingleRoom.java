package org.example.Manage;

public class SingleRoom extends Room {

    SingleRoom() {
        super.setBedSize("Single Bed");
        super.setAllowedPerson(1);
       // super.setSQFT(sqft);
    }

    public int getCost() {
       // int cost = 100 + (int) (super.getSQFT() * 15);
        return 100;
    }

    public String getDescription() {
        StringBuilder str = new StringBuilder();
        str.append("Single Room (").append(super.getBedSize())
                .append(",Allowed Persons ")
                .append(getAllowedPerson()).append(")");
                //.append(super.getSQFT()).append(" sqft").append(")");
        return str.toString();
    }

}