package org.example.models;

import org.example.Utilities;

import static org.example.Utilities.getScanner;

public class Employee {
    private int id;
    private String name;
    private int workingDays;
    private Float dailySalary;

    public void input() {
        System.out.println("Enter id: ");
        this.id = getScanner().nextInt();

        System.out.println("Enter name: ");
        this.name = getScanner().next();

        while (true) {
            System.out.println("Enter working days: ");
            this.workingDays = getScanner().nextInt();
            boolean isValidWorkingDay = this.workingDays >= 1 && this.workingDays <= 31;
            if(isValidWorkingDay) {
                break;
            } else {
                System.err.println("Working days must be 1 to 31");
            }
        }

        while (true) {
            System.out.println("Enter daily salary: ");
            this.dailySalary = getScanner().nextFloat();
            boolean isValidDailySalary = this.dailySalary >= 10 && this.dailySalary <= 100;
            if(isValidDailySalary) {
                break;
            } else {
                System.err.println("Daily salary must be 10 to 100");
            }
        }


    }
    public Employee() {}
    public Employee(int id, String name, int workingDays, Float dailySalary) {
        this.id = id;
        this.name = name;
        this.workingDays = workingDays;
        this.dailySalary = dailySalary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(int workingDays) {
        this.workingDays = workingDays;
    }

    public Float getDailySalary() {
        return dailySalary;
    }

    public void setDailySalary(Float dailySalary) {
        this.dailySalary = dailySalary;
    }
    public Float getMonthlySalary() {
        return dailySalary * workingDays;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", workingDays=" + workingDays +
                ", dailySalary=" + dailySalary +
                ", MonthlySalary =" + getMonthlySalary();
    }
}
