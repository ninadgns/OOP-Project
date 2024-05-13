package org.manage;

public class OtherFacilities {

    private boolean kitchen;
    private boolean parking;
    private boolean wifi;
    private boolean pool;
    private boolean garden;
    private boolean commonBath;

    OtherFacilities(boolean kitchen, boolean parking, boolean wifi, boolean pool, boolean garden, boolean commonBath) {
        setPool(pool);
        setWifi(wifi);
        setParking(parking);
        setKitchen(kitchen);
        setGarden(garden);
        setCommonBath(commonBath);
    }

    public boolean getCommonBath() {
        return this.commonBath;
    }

    public boolean getGarden() {
        return this.garden;
    }

    public boolean getKitchen() {
        return this.kitchen;
    }

    public boolean getParking() {
        return this.parking;
    }

    public boolean getWifi() {
        return this.wifi;
    }

    public boolean getPool() {
        return this.pool;
    }

    public void setCommonBath(boolean commonBath) {
        this.commonBath = commonBath;
    }

    public void setGarden(boolean garden) {
        this.garden = garden;
    }

    public void setKitchen(boolean kitchen) {
        this.kitchen = kitchen;
    }

    public void setParking(boolean parking) {
        this.parking = parking;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public void setPool(boolean pool) {
        this.pool = pool;
    }
}
