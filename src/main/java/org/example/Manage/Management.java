package org.example.Manage;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Management {
    private ArrayList<Area> areaList;

    public Management() {
        this.areaList = new ArrayList<>();
        addArea();
    }

    public void addArea() {
        areaList.add(new Area("Saint Martin"));
        areaList.add(new Area("Sajek"));
        // areaList.add(new Area("Bandarban"));
        // areaList.add(new Area("Cox's Bazar"));
    }

    public ArrayList<Area> getAreaList() {
        return this.areaList;
    }

    public Area getAreabyName(String name) {
        return this.areaList.stream().filter(area -> area.getDistrictName().equals(name)).findFirst().orElse(null);
    }

}
