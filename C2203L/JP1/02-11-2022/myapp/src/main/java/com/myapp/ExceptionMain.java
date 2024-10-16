package com.myapp;

import com.myapp.aptech.Employee;

import java.util.Scanner;

public class ExceptionMain {
    public static void main(String[] args) {
        /*
        Person person = new Person();
        person.setName("Hoang");
        person.setAge(18);
        person.display();
         */
        //casting = ep kieu
        /*
        float x = 100.12f;
        double y = x;//implicit casting
        int xx = (int)x; //explicit casting
         */
        Employee mrJohn = new Employee();
        mrJohn.setName("John");//child(derived, sub) class(Employee) can call parent(super)'s method(Person)
        mrJohn.setSalary(1000.0f);
        mrJohn.display();
        final Employee mrX = new Employee();
        //mrX = mrJohn;//error
        mrX.setName("xxxx"); //ok, final but "mutable"

        Employee mrHoang = new Employee();
        float xx1 = 120.0e+11f;//exponential, not e(2.718)
        System.out.println("haha"+Calculation.sum(1,3));

        int choice = 0;
        do {
            System.out.println(
                    "1. Input Person \n"+
                    "2. Find Person \n" +
                    "3. Exit");
            System.out.println("Enter your choice(1-3) : ");
            choice = (new Scanner(System.in)).nextInt();
            switch (choice) {
                case 1:{
                    System.out.println("You choose 1");
                    break;
                }
                case 2: {
                    System.out.println("You choose 2");
                    break;
                }
                default:
                    System.err.println("Please chooose 1-3: ");
                    break;
            }
        }while (choice != 3);
        System.out.println("Program ended");
    }
}