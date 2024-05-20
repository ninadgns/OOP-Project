package org.example.Manage;

public class Cabin extends Hotel {
    public Cabin(String address, String district, String name, double sqft) {
        setAddress(address);
        setType("Cabin");
        setName(name);
        setDistrict(district);
        setSqft(sqft);
    }
}

