package com.aptech.de02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderCake extends Cake{
    private float weight;
    public OrderCake() {}
    public OrderCake(String name, Double rate, float weight) {
        super(name, rate);
        this.weight = weight;
    }

    @Override
    public double calculatePrice() {
        return rate * weight;
    }

    @Override
    public void input() {
        super.input();
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter weight: ");
            this.weight = Float.valueOf(in.readLine());
        }catch (IOException e) {
            System.err.println("Input data error: "+e.getMessage());
        }
    }
}
