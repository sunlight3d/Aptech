package com.aptech.springrestapi.restservice.models;

public class Product {
    private long id;
    private String name;
    private Integer year;
    private String description;

    public Product(long id, String name,Integer year, String description) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.description = description;
    }
    public void sayHello(String friendName) {
        System.out.println(String.format("Hello %s", friendName));
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("id = %d, name = %s, year = %d, description = %s",
                this.id,
                this.name,
                this.year,
                this.description
        );
    }
}
