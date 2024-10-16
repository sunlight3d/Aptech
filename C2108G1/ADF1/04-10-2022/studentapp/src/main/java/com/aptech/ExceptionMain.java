package com.aptech;

import java.util.Scanner;

public class ExceptionMain {
    //bai 2
    public static void main(String[] args) {

        PersonManager personManager = new PersonManager();
        int choice = 0;
        while (choice != 3) {
            System.out.println("1. Input person");
            System.out.println("2. Find person");
            System.out.println("3. Exit");
            System.out.println("Enter your choice: ");
            choice = (new Scanner(System.in)).nextInt();
            if(choice == 1) {
                personManager.getPersons();
                personManager.showAllPersons();
            } else if(choice == 2) {
                System.out.println("Enter person's index to find: ");
                int index = (new Scanner(System.in)).nextInt();
                personManager.findPerson(index);
            }
        }
    }
}
