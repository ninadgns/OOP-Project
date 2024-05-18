package org.example.Manage;

public class Villa extends Hotel {
    public Villa(String address, String district, String name, double sqft) {
        setAddress(address);
        setType("Villa");
        setName(name);
        setDistrict(district);
        setSqft(sqft);
    }
}
