package org.example.Manage;

import java.util.ArrayList;

public class LargeRoom extends Room {
    public LargeRoom() {
        super.setBedSize("King Size Bed");
        super.setAllowedPerson(4);
       // super.setSQFT(sqft);
    }

    public int getCost() {
       // int cost = 400 + (int) (super.getFloorSpace() * 15);
        return 350;
    }

    public ArrayList<String> getAmenities() {
        ArrayList<String> temp = new ArrayList<String>();
        temp.add("Large Room");
        temp.add(super.getBedSize());
        temp.add(String.valueOf(getAllowedPerson()));

        return temp;
    }

    public String getDescription() {
        StringBuilder str = new StringBuilder();
        str.append("Large Room (").append(super.getBedSize())
                .append(",Allowed Persons ")
                .append(getAllowedPerson()).append(")");
               // .append(super.getFloorSpace()).append(" sqft").append(")");

        return str.toString();
    }

}
