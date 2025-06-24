package com.aptech.bai03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int choice = 0;
        while(choice != 6){
            System.out.println("Enter your choice(1-6): ");
            choice = (new Scanner(System.in)).nextInt();
            switch (choice) {
                case 1:
                    System.out.println("add new student");
                    //
                    break;
                case 2:
                    System.out.println("Display all students");
                    break;
                case 3:
                    System.out.println("find student with max gpa");
                    break;
                case 4:
                    System.out.println("filter student");
                    break;
                case 5:
                    System.out.println("Order students");
                    break;
                default:
                    if(choice != 6) {
                        System.out.println("please input 1-6");
                    }
            }
        }
    }
}