package org.example.Manage;

public class LargeRoom extends Room {
    LargeRoom() {
        super.setBedSize("King Size Bed");
        super.setAllowedPerson(4);
       // super.setSQFT(sqft);
    }

    public int getCost() {
       // int cost = 400 + (int) (super.getSQFT() * 15);
        return 350;
    }

    public String getDescription() {
        StringBuilder str = new StringBuilder();
        str.append("Large Room (").append(super.getBedSize())
                .append(",Allowed Persons ")
                .append(getAllowedPerson()).append(")");
               // .append(super.getSQFT()).append(" sqft").append(")");

        return str.toString();
    }

}
