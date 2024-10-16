package com.aptech.de02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public abstract class Cake {
    protected String name;
    protected Double rate;

    public Cake(){}

    public Cake(String name, Double rate) {
        this.name = name;
        this.rate = rate;
    }
    public abstract double calculatePrice();
    public void input(){
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter name: ");
            this.name = in.readLine();
            System.out.print("Enter rate: ");
            this.rate = Double.valueOf(in.readLine());

        }catch (IOException e) {
            System.err.println("Input data error: "+e.getMessage());
        }
    }
    @Override
    public String toString() {
        return "name: "+name+
                "rate: "+rate;
    }
}
