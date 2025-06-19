package com.aptech.doanso;

import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void baitap01() {
        int inputNumber = -1;
        int randomNumber = (new Random()).nextInt(100) + 1; // 1 to 100
        System.out.printf("Random number is %d", randomNumber);
        do {
            System.out.println("Enter a number(1 to 100): ");
            inputNumber = (new Scanner(System.in)).nextInt();
            if(inputNumber < randomNumber) {
                System.out.println("Input number less than random number");
            } else if(inputNumber > randomNumber) {
                System.out.println("Input bigger than randome number");
            } else {
                System.out.println("You got the right number ");
            }

        }while(inputNumber != randomNumber);
        int sumOddValues = 0;
        int sumEvenValues = 0;
        int numberOfOdds =0;
        int numberOfEvens = 0;

        for(int i = 1; i <= randomNumber; i++) {
            if(i % 2 == 0) {
                numberOfEvens ++;
                //sumEvenValues = sumEvenValues +i;
                sumEvenValues += i;
            } else {
                numberOfOdds ++;
                sumOddValues += i;
            }

        }
    }
    public static void baitap02() {
        int choice = 0;
        //Scanner scanner = ;
        while(choice != 4) {
            System.out.println("Enter your choice : ");
            choice = (new Scanner(System.in)).nextInt();
            switch (choice) {
                case 1:
                    System.out.println("You choose 1");
                    break;
                case 2:
                    System.out.println("You choose 2");
                    break;
                case 3:
                    System.out.println("You choose 23");
                    break;
                default:
                    System.out.println("You must choose 1-4");
            }
        }
    }
    public static void baitap03() {
        double sum = 1.0;
        while (true) {
            sum *= 2;
            System.out.println("Value of sum: "+sum);
        }
    }
    public static void main(String[] args) {
        //baitap01();
        //baitap02();

        /*
        Main main = new Main();
        main.baitap01();
         */
        baitap03();
    }
}