package org.example.Manage;

public class Cottage extends Hotel {
    public Cottage(String address, String district, String name, double sqft) {
        setAddress(address);
        setType("Cottage");
        setName(name);
        setDistrict(district);
        setSqft(sqft);
    }
}