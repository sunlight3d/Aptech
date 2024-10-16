package com.myapp;

import com.myapp.models.Employee;

import java.util.Scanner;

public class Main {
    private static boolean checkSingleValueString(int x) {
        String xString = String.valueOf(x);
        if(xString.length() == 0) {
            return false;
        }
        for (int i = 0; i < xString.length(); i++) {
            if(xString.charAt(i) != xString.charAt(0)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        /*
        int x = 12;//primitive types(int, float, double,...)
        Integer x1 = 123;
        int y = 13;
        System.out.println("Value : "+String.valueOf(x+y));
        System.out.println(String.format("value of x = %d, y = %d", x, y));
        System.out.println("max int is: "+Integer.MAX_VALUE);
        System.out.println("min int is: "+Integer.MIN_VALUE);

        Calculation calculation = new Calculation();
        System.out.println("one plus two is: "+calculation.sum(1,2));
        long creditCard = 1234_5678_9101_1213L;
        double pi = 3.14;
        Season season = Season.SPRING;
        if(season.equals(Season.SPRING)){
            System.out.println("This is spring");
        }
        */
        /*
        String studentName = "Nguyen Van A";
        String studentNumber = "A1234";
        System.out.println(String.format("name is %s, number is %s", studentName, studentNumber));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter N = ");
        int N = scanner.nextInt();
        int result = 0;
        for(int i = 1; i <= N; i++) {
            result = i %2 == 0 ? result + i : result;
            if(checkSingleValueString(i)) {
                System.out.println(i);
            }
        }
        System.out.println("result = "+result);
        */
        Employee mrA = new Employee(1, "John", 18, "IT");
        Employee mrB = new Employee(1, "John", 18, "IT");
        mrA.setAge(30);
        //How to reference an object
        Employee mrC = mrA; //ref
        Employee mrD = mrA;
        Employee mrE = mrA;
        mrC.setDepartment("Sales");
        mrC = null;
        mrA = null;
        mrD = null;
        mrE = null;
        System.out.println("haha");

    }
}