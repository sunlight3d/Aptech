package com.aptech.project02.models;

public class Employee{
    private String name;
    private float salary;
    public static float BASE_SALARY = 5_000_000.0f;

    public Employee() {

    }
    public static void haha() {
        System.out.println("haha");
        //this.name = "abc";
    }
    public Employee(String name, float salary) {
        this.name = name;
        //this.salary = salary;
        setSalary(salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary >= BASE_SALARY ? salary : this.salary;
    }

    @Override
    public String toString() {
        return "name: "+this.name + ",salary"+this.salary;
    }
}
