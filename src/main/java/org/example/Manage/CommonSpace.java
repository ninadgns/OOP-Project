package org.example.Manage;

public interface CommonSpace {
    public abstract String getDescription();
    public abstract int getCost();
}

class IndoorSpace implements CommonSpace {
    public String getDescription() {
        return "Indoor Spaces:";
    }

    public int getCost() {
        return 50;
    }
}

class OutdoorSpace implements CommonSpace {
    public String getDescription() {
        return "Outdoor Spaces:";
    }

    public int getCost() {
        return 50;
    }
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