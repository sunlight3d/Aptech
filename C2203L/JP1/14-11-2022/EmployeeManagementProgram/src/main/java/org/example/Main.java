package org.example;

import org.example.models.Employee;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice = 0;
        while (choice != 7) {
            System.out.println("+------------------------------------------------------------------+");
            System.out.println("                   EMPLOYEE MANAGEMENT PROGRAM                     |");
            System.out.println("+------------------------------------------------------------------+");
            System.out.println("|1. Input |2. Sort |3. Analyze |4. Find |5. Save |6. Open |7. Exit |");
            System.out.println("+------------------------------------------------------------------+");
            EmployeeManagement employeeManagement = new EmployeeManagement();
            System.out.println("Enter your choice: ");
            choice = (new Scanner(System.in)).nextInt();
            switch (choice) {
                case 1:
                    //System.out.println("You choose 1");
                    employeeManagement.inputEmployees();
                    break;
                case 2:
                    //System.out.println("You choose 2");
                    employeeManagement.sort();
                    break;
                case 3:
                    //System.out.println("You choose 3");
                    employeeManagement.analyze();
                    break;
                case 4:
                    employeeManagement.findHighestSalary();
                    //System.out.println("You choose 4");
                    break;
                case 5:
                    //System.out.println("You choose 5");
                    employeeManagement.save();
                    break;
                case 6:
                    //System.out.println("You choose 6");
                    employeeManagement.open();
                    break;
                case 7:
                    System.out.println("You choose 7");
                    break;
                default:
                    System.out.println("You choose 1");
                    break;
            }
            if(choice == 7) {
                break;
            }
            System.out.println("Do you want to continue ?");
            System.out.println("- Yes, I do. (press ‘y’, ‘Y’)");
            System.out.println("- No, I don’t. (press ‘n’, ‘N’)");
            System.out.println("- Please clear the screen ! (press ‘c’, ‘C’)");
            System.out.println("Your choice:");
            String confirm = (new Scanner(System.in)).next();
            if(confirm.trim().toLowerCase().equals("y")) {

            }else if(confirm.trim().toLowerCase().equals("n")) {
                break;
            }else if(confirm.trim().toLowerCase().equals("c")) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            } else {
                System.err.println();
            }
        }
        System.out.println("Program ended");
    }
}