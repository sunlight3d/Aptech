package com.aptech.models;

public class Pizza {
    private Double diameter;
    private Integer slices;

    public Pizza() {

    }

    public Pizza(Double diameter, Integer slices) {
        this.diameter = diameter;
        this.slices = slices;
    }

    @Override
    public String toString() {
        return "diameter : "+this.diameter+", "+
                "slices : "+this.slices+", ";
    }
}

