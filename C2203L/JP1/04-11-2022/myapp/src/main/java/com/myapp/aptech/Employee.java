package com.myapp.aptech;

import java.util.Scanner;

public class Employee extends Person {
    private float salary;

    @Override
    public void input() {
        super.input();//"person".input()
        System.out.println("Enter salary: ");
        this.salary = (new Scanner(System.in)).nextFloat();
    }

    //overload = methods with same names, different parameters
    public void increaseSalary(int x) {
        salary = salary + x;
    }
    public void increaseSalary(double x) {
        //salary = (float) (salary * x);
        salary = salary * (float) x;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    //override: parent's method has the same name/parameters with child's method
    @Override
    public void display() {
        super.display();
        System.out.println("salary: "+this.salary);
    }

    //static variable
    public static float BASE_SALARY = 1000;


}
