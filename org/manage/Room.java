package org.manage;

public class Room {

    private String bedSize;
    private int allowedPersons;
    private String facilities;
    private boolean attachedBath;
    private boolean sharedRoom;
    private double sqFt;

    Room(String bedSize, int allowedPersons, boolean attachedBath, double sqFt) {
        this.bedSize = bedSize;
        this.allowedPersons = allowedPersons;
        this.attachedBath = attachedBath;
        this.sqFt = sqFt;
    }

    public int getAllowedPerson() {
        return this.allowedPersons;
    }

    public void setAllowedPerson(int allowedPerson) {
        this.allowedPersons = allowedPerson;
    }

    public String getBedSize() {
        return this.bedSize;
    }

    public void setBedSize(String bedSize) {
        this.bedSize = bedSize;
    }

    public String getFacilities() {
        return this.facilities;
    }

    public void setFacilities(String facility) {
        this.facilities = facility;
    }

    public double getSQFT() {
        return this.sqFt;
    }

    public boolean getAttachedBath() {
        return this.attachedBath;
    }

    public boolean getSharedRoom() {
        return this.sharedRoom;
    }

    public void setSharedRoom(boolean sharedRoom) {
        this.sharedRoom = sharedRoom;
    }

}
