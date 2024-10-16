package com.application;
import com.application.models.Calculation;
import com.application.models.Person;

import java.util.Locale;
import java.util.Scanner;
//int xx = 123;//NO!
public class Main {
    public static void doSomething() {
        System.out.println("Chao cac ban");
    }
    public static void main(String[] args) throws Exception {
        //primitive data type: int, float, double
        float x1 = 11.2f;
        double x11 = 1234.5;
        float y1 = x1;//assignment
        x1 = 22.3f;
        //what is value of y1 ?
        //reference daa type
        Person person1 = new Person("nguyen van a", "vietnam", 1993, 33.2f);
        Person person2 = person1;//reference , "NOT assign"
        //person1 = null;
        //person2 = null;
        person1.setName("nbguyen van X");
        
        //what is value of person2.getName() => ?
        System.out.println(Calculation.PI);//call a static field/variable
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