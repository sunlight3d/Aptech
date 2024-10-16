package com.aptech.de02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadyMakeCake extends Cake{
    private Integer quantity;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ReadyMakeCake() {}

    public ReadyMakeCake(String name, Double rate, Integer quantity) {
        super(name, rate);
        this.quantity = quantity;
    }

    @Override
    public double calculatePrice() {
        return rate * quantity;
    }
    @Override
    public void input() {
        super.input();
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter quantity: ");
            this.quantity = Integer.valueOf(in.readLine());
        }catch (IOException e) {
            System.err.println("Input data error: "+e.getMessage());
        }
    }
}
