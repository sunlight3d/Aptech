package com.aptech;

import lombok.*;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
public class Pizza {
    private Double diameter;
    private Integer numberOfSlices;
    public Pizza() {

    }
    public Pizza(Double diameter, Integer numberOfSlices) {
        this.diameter = diameter;
        this.numberOfSlices = numberOfSlices;
    }

    public Double getDiameter() {
        return diameter;
    }

    public void setDiameter(Double diameter) {
        this.diameter = diameter;
    }

    public Integer getNumberOfSlices() {
        return numberOfSlices;
    }

    public void setNumberOfSlices(Integer numberOfSlices) {
        this.numberOfSlices = numberOfSlices;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "diameter=" + diameter +
                ", numberOfSlices=" + numberOfSlices +
                '}';
    }

}
