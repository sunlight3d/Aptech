package com.aptech.de02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        SavingsAccount saver1 = new SavingsAccount(2000.0);
        SavingsAccount saver2 = new SavingsAccount(3000.0);
        SavingsAccount.modifyAnnualInterestRate(0.4f);
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        System.out.println(saver1);
        System.out.println(saver2);

        SavingsAccount.modifyAnnualInterestRate(0.5f);
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        System.out.println(saver1);
        System.out.println(saver2);
        ArrayList<Cake> cakes = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            System.out.println("Enter OrderCake(1), ReadyMadeCake(2):");
            int cakeType = 1;
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                cakeType = Integer.valueOf(in.readLine());
                /*
                if(cakeType == 1) {
                    OrderCake cake = new OrderCake();
                    cake.input();
                } else {
                    ReadyMakeCake cake = new ReadyMakeCake();
                    cake.input();
                }
                */
                Cake cake = cakeType == 1 ? new OrderCake() : new ReadyMakeCake();
                cake.input();
                cakes.add(cake);
            }catch (IOException e) {
                System.err.println("Input data error: "+e.getMessage());
            }
        }
//        cakes.add(new OrderCake("x1", 15.0, 1.23f));
//        cakes.add(new OrderCake("y1", 1.0, 1.23f));
//        cakes.add(new ReadyMakeCake("x2", 12.0, 2));
//        cakes.add(new OrderCake("x3", 13.0, 1.23f));
//        cakes.add(new ReadyMakeCake("y2", 13.0, 6));
//        cakes.add(new OrderCake("x4", 1.20, 1.23f));

        double totalPrice = 0.0;
        double totalPriceOrderCake = 0.0;
        double totalPriceReadyMakeCake = 0.0;
        int totalQuantityOfReadyMakeCake = 0;
        double maxPrice = Double.MIN_VALUE;
        for (Cake cake: cakes) {
            totalPrice += cake.calculatePrice();
            if(cake instanceof OrderCake) {
                totalPriceOrderCake += cake.calculatePrice();
            }else if(cake instanceof ReadyMakeCake) {
                totalPriceReadyMakeCake += cake.calculatePrice();
                totalQuantityOfReadyMakeCake += ((ReadyMakeCake) cake).getQuantity();
            }
//            if(cake.calculatePrice() > maxPrice) {
//                maxPrice = cake.calculatePrice();
//            }
            maxPrice = (cake.calculatePrice() > maxPrice) ? cake.calculatePrice() : maxPrice;
        }

        System.out.println(
                "totalPrice : "+totalPrice+"\n"+
                "totalPriceOrderCake : "+totalPriceOrderCake+"\n"+
                "totalPriceReadyMakeCake : "+totalPriceReadyMakeCake+"\n"+
                "totalQuantityOfReadyMakeCake : "+totalQuantityOfReadyMakeCake+"\n"+
                "maxPrice : "+maxPrice+"\n"
        );
    }
}