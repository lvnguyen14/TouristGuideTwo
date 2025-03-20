package com.example.touristguidetwo.model;

public class Tags {
    private String name;
    private int tagID;

    public Tags(String name, int tagID){
        this.name = name;
        this.tagID = tagID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTagID() {
        return tagID;
    }

    public void setTagID(int tagID) {
        this.tagID = tagID;
    }

}
