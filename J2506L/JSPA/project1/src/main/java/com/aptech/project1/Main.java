package com.aptech.project1;

import com.aptech.project1.models.Product;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static int factorial(int n) {
        /*
        if(n < 1) {
            return 1;
        }
        return n*factorial(n-1);
         */
        return  n < 1 ? 1 : n * factorial(n-1);
        /*
        int result = 1;
        while (n > 0) {
            result = result *n;
            n = n - 1;
        }
        return result;
         */
    }
    public static void main(String[] args) {
        System.out.println("hello world");
        int x = 10;
        int y = 20;
        int sum = x + y;
        //System.out.println("sum is : "+sum);
        //string concatenation
        System.out.printf("sum = %d", sum);
        long creditCard = 1234_5678_91011L;
        float a = 123f;
        double b = 2345.0;
        //casting = ep kieu
        double c = (double) a;
        float d = (float) b;
        String lastName = "Duc Hoang";
        String firstName = "Nguyen";
        String fullName = firstName + " "+ lastName;
        //firstName.charAt(0);
        //char age = 20;
//        System.out.println("Enter age : ");
//        int age = (new Scanner(System.in)).nextInt();
        /*
        boolean isOld = age > 50;
        System.out.println("is old: "+isOld);
        */
        int mark = 7;
        int m = 10;
        if(m % 2 == 0){
            System.out.println("This is even");
        }
        System.out.println("factorial of 4: "+factorial(5));
        for(int i = 0; i < 10; i++){
            if(i % 2 == 0) {
                System.out.println(i);
            }
        }
        Product productA = new Product();
        //productA.name = "iphone 17";//cannot access "name" because "private"
        productA.setName("iphone 17");
        System.out.println(productA.getName());
        productA.setPrice(123);
        System.out.println("haha");
        Product productB = productA;//reference
        productB.setName("iphone 14");
        //productB = null;
        System.out.println(productA.getName());
        System.out.println(productB.getName());
        Product productC = new Product();
        productC.setName(productA.getName());//clone, assign
        productC.setPrice(productA.getPrice());
        productA.setName("xx");
        productC.setName("yy");
        System.out.println("haha");
    }
}