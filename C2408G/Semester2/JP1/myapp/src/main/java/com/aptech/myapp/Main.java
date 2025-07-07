package com.aptech.myapp;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static final String BASE_URL = "http://localhost:3000";
    public static void main(String[] args) {
        int x = 1;
        int y = 2;
        int sum = x + y;
        System.out.println(sum);
        //strint concatenation
        System.out.printf("sum = %d, x = %d, y = %d \n",sum, x, y);
        int numberOfStudents = 100;
        //int number_of_students = 100; //NO!
        long MY_CREDIT_CARD = 1234_5678_9101_1214L;
        System.out.println("chao ban");

        //reference type
        Person personA = new Person();
        personA.name = "Nguyen Van A";
        Person personB = personA;//reference type
        personA.name = "Nguyen Van B";
        System.out.println(personB.name);

        Person personX = new Person();
        personX.name = "Nguyen Van X";

        //primitive type
        Integer a = 10;
        Integer b = a;//assignment
        a = 20;
        //b = ?
        System.out.println(b);
        //personB.name = ?
    }
}