package com.aptech.project02.models;

public abstract class Employee {
    private String name;
    private double baseSalary;
    public abstract double calculateSalary();

    public double getBaseSalary() {
        return baseSalary;
    }

    public Employee(String name, double baseSalary) {
        //all arguments constructor
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
