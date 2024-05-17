package org.example.Manage;

import java.util.ArrayList;

public class SingleRoom extends Room {

    public SingleRoom() {
        super.setBedSize("Single Bed");
        super.setAllowedPerson(1);
        // super.setSQFT(sqft);
    }

    public int getCost() {
        // int cost = 100 + (int) (super.getFloorSpace() * 15);
        return 100;
    }

    public ArrayList<String> getAmenities() {
        ArrayList<String> temp = new ArrayList<String>();
        temp.add("Single Room");
        temp.add(super.getBedSize());
        temp.add(String.valueOf(getAllowedPerson()));
        return temp;
    }

    public String getDescription() {
        StringBuilder str = new StringBuilder();
        str.append("Single Room (").append(super.getBedSize())
                .append(",Allowed Persons ")
                .append(getAllowedPerson()).append(")");
        // .append(super.getFloorSpace()).append(" sqft").append(")");
        return str.toString();
    }

}