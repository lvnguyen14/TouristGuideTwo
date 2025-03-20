package com.example.touristguidetwo.model;

public class City {
    private String name;
    private int cityID;

    public City(String name, int cityID){
        this.cityID = cityID;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }
}
