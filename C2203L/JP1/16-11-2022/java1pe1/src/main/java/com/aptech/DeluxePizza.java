package com.aptech;

public class DeluxePizza extends Pizza{
    private String addedToppings;

    public DeluxePizza(String addedToppings,
                       Double diameter, Integer numberOfSlices
                       ) {
        super(diameter, numberOfSlices);
        this.addedToppings = addedToppings;
    }
}
