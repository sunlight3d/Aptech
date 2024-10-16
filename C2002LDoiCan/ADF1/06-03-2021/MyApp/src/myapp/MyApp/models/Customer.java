package myapp.MyApp.models;

import java.util.Scanner;

public class Customer extends Person{
    private String model;
    public Customer(String name, String address) {
        super(name, address);
    }
    Customer() {}
    @Override
    public void input() {
        super.input(); 
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter model: ");                
        this.model = scanner.next();
    }
    @Override
    public String toString() {
        return super.toString() + ",model=" + model;
    }
}
