package com.aptech;

public class Employee extends Person{
    private int salary;
    public Employee(){}
    public Employee(String name, Integer age, int salary) {
        super(name, age);
        this.salary = salary;
    }
    //overload
    public void increaseSalary(int x){
        this.salary += x;
    }
    public void increaseSalary(double x){
        this.salary = (int)(this.salary * x);//explicit casting
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("salary:"+salary);
    }
}
