package com.example.callwsapp.models;

public class Food {
    private String foodName;
    private String description;
    private Double price;
    private String url;

    public Food(String foodName,
                String description,
                Double price,
                String url) {
        this.foodName = foodName;
        this.description = description;
        this.price = price;
        this.url = url;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
