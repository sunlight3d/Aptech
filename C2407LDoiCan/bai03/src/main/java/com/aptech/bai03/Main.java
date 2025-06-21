package com.aptech.bai03;

import com.aptech.bai03.entities.Customer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Customer mrA = new Customer();//default constructor,non-parameterized constructor
        //mrA.name = "Hoang"; //cannot access private fields outside class
        /*
        mrA.setId(1);
        mrA.setName("Hoang");
        mrA.setAddress("address a");
        mrA.setAge(20);
         */
        Customer mrA = new Customer(1, "Hoang", "address a", 20);
        mrA.showInformation();
        Customer mrB = new Customer(2,
                "nguyen van b",
                "address b", 20);
        mrB.showInformation();
        System.out.println("haha");
        //1 class => N objects
        //1 class => 1 Object(singleton pattern)
        //Database db = new Database();
        Database db1 = Database.getInstance();
        Database db2 = Database.getInstance();
        Database db3 = Database.getInstance();

    }
}