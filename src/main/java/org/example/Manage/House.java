package org.example.Manage;

public class House implements CommonSpace {

    protected CommonSpace indoorSpace;
    protected CommonSpace outdoorSpace;

    public House(CommonSpace indoorSpace, CommonSpace outdoorSpace) {
        this.indoorSpace = indoorSpace;
        this.outdoorSpace = outdoorSpace;
    }

    @Override
    public String getDescription() {
        StringBuilder str = new StringBuilder();
        str.append(indoorSpace.getDescription()).append("\n");
        str.append(outdoorSpace.getDescription()).append("\n");
        return str.toString();
    }

    @Override
    public int getCost() {
        return indoorSpace.getCost() + outdoorSpace.getCost();
    }
}
