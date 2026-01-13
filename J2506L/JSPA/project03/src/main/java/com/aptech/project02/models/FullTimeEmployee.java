package com.aptech.project02.models;

public class FullTimeEmployee extends Employee{
    private double bonus;

    public FullTimeEmployee(String name, double baseSalary, double bonus) {
        super(name, baseSalary);//re-use "All arguments constructor" of super class
        this.bonus = bonus; //if bonus = -100 => this.bonus = 100; => failed !
        setBonus(bonus);//better if validate => if bonus = -100 => this.bonus unchanged
    }

    public void setBonus(double bonus) {
        this.bonus = bonus < 0 ? this.bonus : bonus;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + bonus;
    }


}
