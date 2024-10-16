package com.myapp;

import com.myapp.aptech.*;

import java.util.ArrayList;
import java.util.Scanner;

public class ExceptionMain {
    public static void main(String[] args) {
        int choice = 0;
        PersonManager personManager = new PersonManager();
        do {
            System.out.println(
                    "1. Input Person \n"+
                    "2. Find Person \n" +
                    "3. Exit");
            System.out.println("Enter your choice(1-3) : ");
            choice = (new Scanner(System.in)).nextInt();
            switch (choice) {
                case 1:{
                    //System.out.println("You choose 1");
                    personManager.setPersons();
                    personManager.getPersons();
                    break;
                }
                case 2: {
                    //System.out.println("You choose 2");
                    try {
                        personManager.findPerson();
                    }catch (Exception e) {
                        System.err.println("Cannot find person. Error: "+e.getMessage());
                    }

                    break;
                }
                default:
                    System.err.println("Please chooose 1-3: ");
                    break;
            }
        } while (choice != 3);
        System.out.println("Program ended");
    }
}