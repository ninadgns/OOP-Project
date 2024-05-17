package org.example.Manage;

public interface CommonSpace {
    public abstract String getDescription();
    public abstract int getCost();
}

abstract class OutdoorDecorator implements CommonSpace {
    private CommonSpace decoOutdoorSpace;

    OutdoorDecorator (CommonSpace decoOutdoorSpace){
        this.decoOutdoorSpace=decoOutdoorSpace;
    }

    public int getCost() { 
        return this.decoOutdoorSpace.getCost();
    }
    public String getDescription() {
        return this.decoOutdoorSpace.getDescription();
    }

}

abstract class IndoorDecorator implements CommonSpace {
    private CommonSpace decoIndoorSpace;

    IndoorDecorator(CommonSpace decoIndoorSpace){
        this.decoIndoorSpace=decoIndoorSpace;
    }

    public int getCost() { 
        return this.decoIndoorSpace.getCost();
    }
    public String getDescription() {
        return this.decoIndoorSpace.getDescription();
    }
}