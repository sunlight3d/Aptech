/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.MyApp.models;

import java.util.Scanner;

public class Employee extends Person{
    private Float salary;
    private String position;
    Employee() {}
    public Employee(String name, String address) {
        super(name, address);
    }

    @Override
    public void input() {
        super.input(); 
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter salary: ");
        this.salary = scanner.nextFloat();
        System.out.println("Enter postition: ");
        this.position = scanner.next();
    }
    @Override
    public String toString() {
        return super.toString() + ",salary=" + salary 
                + ", position=" + position;
    }
}
