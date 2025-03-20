package com.example.touristguidetwo.model;

import java.util.List;

public class TouristAttraction {
    private int attractionID;
    private String name;
    private String description;
    private City city;
    private Tags tags;

    // Konstruktor
    public TouristAttraction(int attractionID, String name, String description, City city, Tags tags) {
        this.attractionID = attractionID;
        this.name = name;
        this.description = description;
        this.city = city;
        this.tags = tags;
    }

    public TouristAttraction() {
        this.name = "";
        this.description = "";
        this.city = new City("", 0);
        this.tags = new Tags("", 0);
    }


    // Getters og setters


    public int getAttractionID() {
        return attractionID;
    }

    public void setAttractionID(int attractionID) {
        this.attractionID = attractionID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Tags getTags(){
        return tags;
    }

    public void setTags(Tags tags){
        this.tags = tags;
    }
}

