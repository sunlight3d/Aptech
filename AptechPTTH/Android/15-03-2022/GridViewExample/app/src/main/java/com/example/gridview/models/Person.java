package com.example.gridview.models;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private int imageId;

    public Person(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    //maybe: convert object from json
    //factory method
    //Facade pattern
}
