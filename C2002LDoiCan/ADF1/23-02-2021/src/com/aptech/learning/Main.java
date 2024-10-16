package com.aptech.learning;

import com.aptech.models.Vehicle;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static  Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        //Vehicle car1 = new Vehicle();
        //Tao ra mot vai car
        //Vi du them ve thuoc tinh static ?

        System.out.println("min's price of all cars = "+Vehicle.MIN_PRICE);

        Vehicle car1 = new Vehicle("mazda 1", 1000.0, 99.0);
        Vehicle car2 = new Vehicle("mazda 2", 2000.0, 150.0);
        Vehicle car3 = new Vehicle("mazda 3", 510.0, 220.0);
        System.out.println("tax of car2 = "+car2.getTax());
        ArrayList<Vehicle> someCars = new ArrayList<>();
        someCars.add(car1);
        someCars.add(car2);
        someCars.add(car3);
        Hashtable aPerson = new Hashtable();
        aPerson.put("name","Hoang");//a flexible object
        aPerson.put("email","hoang@gmail.com");
        aPerson.put("age",18);
        System.out.println("haha");
        /*
        int i = 3;
        while(i < 3) {
            System.out.println("Enter a String : ");
            String x = Main.scanner.nextLine();
            System.out.println("ban da nhap : "+x);
            i++;
        }
        */
        //MyDatabase myDatabase = new MyDatabase();//ok
        int choice = 0;
        while(choice !=3){
            System.out.println("Enter your choice(1,2,3)");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Ban chon 1");
                    break;
                case 2:
                    System.out.println("Ban chon 2");
                    break;
                case 3:
                    break;
                default:
                    System.out.println("nham roi");
                    break;
            }
        }
    }
}
