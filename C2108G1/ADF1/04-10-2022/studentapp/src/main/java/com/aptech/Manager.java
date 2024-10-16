package com.aptech;

import java.util.Scanner;

public class Manager extends Employee implements Tax{
    private double bonus;
    public Manager(){}
    public Manager(String name, Integer age, int salary, double bonus) {
        super(name, age, salary);
        this.bonus = bonus;
    }

    @Override
    public double calculateTax() {
        bonus = getSalary()*0.2;
        double tax = getSalary()*0.1;
        setSalary((int)(getSalary() + bonus - tax));
        return tax;
    }
    @Override
    public void input() {
        super.input();
        System.out.println("Input bonus:");
        this.bonus = (new Scanner(System.in)).nextDouble();
    }
    @Override
    public void display() {
        super.display();//"employee".display()
        System.out.println("bonus: "+this.bonus);
    }
    @Override
    public String toString() {
        return super.toString()+
                ",bonus:"+bonus;
    }
}
