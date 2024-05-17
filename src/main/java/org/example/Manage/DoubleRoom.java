package org.example.Manage;

import java.util.ArrayList;

public class DoubleRoom extends Room {
   public DoubleRoom() {
        super.setBedSize("Queen Size Bed");
        super.setAllowedPerson(3);
        //super.setSQFT(sqft);
    }

    public int getCost() {
       // int cost = 250 + (int) (super.getFloorSpace() * 15);
        return 250;
    }

    public ArrayList<String> getAmenities() {
        ArrayList<String> temp = new ArrayList<String>();
        temp.add("Double Room");
        temp.add(super.getBedSize());
        temp.add(String.valueOf(getAllowedPerson()));
        return temp;
    }

    public String getDescription() {
        StringBuilder str = new StringBuilder();
        str.append("Double Room (").append(super.getBedSize())
                .append(",Allowed Persons ")
                .append(getAllowedPerson()).append(")");
                //.append(super.getFloorSpace()).append(" sqft").append(")");
        return str.toString();
    }

}
