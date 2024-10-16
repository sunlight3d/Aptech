package com.myapp.aptech;

import java.util.Scanner;

public class Manager extends Employee implements Tax {
    private double bonus;
    @Override
    public double calculateTax() {
        bonus = getSalary()*0.2;
        double tax = getSalary()*0.1;
        setSalary((float) (getSalary() + bonus - tax));
        //salary = salary + bonus – tax,

        return 0;
    }

    @Override
    public void input() throws Exception {
        super.input();
        System.out.println("Enter bonus: ");
        this.bonus = (new Scanner(System.in)).nextDouble();
    }

    @Override
    public void display() {
        super.display();
        System.out.println("\nbonus: "+this.bonus);
    }
}
