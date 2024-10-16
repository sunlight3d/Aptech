package com.aptech.models;

public class DeluxePizza extends Pizza{
    private String toppings;

    public DeluxePizza() {

    }
    public DeluxePizza(String toppings, Double diameter, Integer slices) {
        super(diameter, slices);
        this.toppings = toppings;
    }
    @Override
    public String toString() {
        return "toppings : "+this.toppings +", "+ super.toString();
    }
}
