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
//        Person mrA = new Person();
//        mrA.name = "Hoang";
//        mrA.birthYear = 2000;
//        mrA.nationality = "Vietnam";
//        mrA.netWorth = 5_000_000;
        PersonManagement personManagement = new PersonManagement();
        personManagement.showMenu();
        System.out.println("Program finished");
    }
}