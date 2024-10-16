package com.application;
import com.application.models.Person;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void doSomething() {
        System.out.println("Chao cac ban");
    }
    public static void main(String[] args) throws Exception {
        //primitive value: int, float, double,...
//        doSomething();
//        for(int i = 0; i < 1000; i++) {
//            System.out.println(String.format("Value of x is: %d", i));
//        }
        Person mrA = new Person();
        mrA.name = "Hoang";
        mrA.birthYear = 2000;
        mrA.nationality = "Vietnam";
        mrA.netWorth = 5_000_000;
        //System.out.println("ddd");
        System.out.println("+---------------------------------------------------------+");
        System.out.println("+--------Milisionaraby dad--------+");
        System.out.println("+1-Input, 2-Sort, 3-Analyze, 4-Find, 5-Open, 6-Save, 7-Exit+");
        System.out.println("+---------------------------------------------------------+");
        int choice = 0;
        while (choice != 7){
            System.out.println("Enter your choice: ");
            choice = (new Scanner(System.in)).nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("You choose 1");
                    break;
                }
                case 2: {
                    System.out.println("You choose 2");
                    break;
                }
                case 3: {
                    System.out.println("You choose 3");
                    break;
                }
                case 4: {
                    System.out.println("You choose 4");
                    break;
                }
                case 5: {
                    System.out.println("You choose 5");
                    break;
                }
                case 6: {
                    System.out.println("You choose 6");
                    break;
                }
                case 7: {
                    System.out.println("You choose 7");
                    break;
                }
                default:
                    System.out.println("Invalid, please select(1 - 7)");
            }
            System.out.println("Do you want to continue(y, n, c) ?");
            String decision = (new Scanner(System.in)).next();
            if(decision.trim().toLowerCase().equals("y")) {
                //do nothing
            } else if(decision.trim().toLowerCase().equals("n")) {
                break;
            } else if(decision.trim().toLowerCase().equals("c")) {
                final String os = System.getProperty("os.name");
                if (os.contains("Windows"))
                {
                    Runtime.getRuntime().exec(new String[] {"cls"});
                } else {
                    Runtime.getRuntime().exec(new String[] {"clear"});
                }
            }
        }
        System.out.println("Program finished");
    }
}