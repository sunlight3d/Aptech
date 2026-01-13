package com.aptech.project02.models;

public class ParttimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public ParttimeEmployee(String name,
                            double baseSalary,
                            int hoursWorked,
                            double hourlyRate

    ) {
        super(name, baseSalary);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    /*
    unecessary !
    let use Builder pattern => @Builder
    public ParttimeEmployee(String name,

                            int hoursWorked,
                            double hourlyRate

    ) {
        super(name, 0);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }
*/
    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}
