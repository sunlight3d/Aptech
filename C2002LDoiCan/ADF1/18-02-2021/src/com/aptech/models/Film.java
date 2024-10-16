package com.aptech.models;

public class Film {
    private String name;
    private Integer year;
    private Double duration;
    //constructor = ham khoi tao
    public Film(String name, Integer year, Double duration) {
        this.name = name;
        this.year = year;
        this.duration = duration;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    //getter
    public Integer getYear() {
        return year;
    }
    //setter
    public void setYear(Integer year) {
        this.year = year;
    }

    public void setName(String name) {
        //this is a "setter"
        this.name = name;
    }
    public String getName() {
        //this is a "getter"
        return name;
    }

    @Override
    public String toString() {
        return "name : "+this.name+"\n"+
                "year :" + this.year+"\n"+
                "duration: "+this.duration+"\n";
    }
}
