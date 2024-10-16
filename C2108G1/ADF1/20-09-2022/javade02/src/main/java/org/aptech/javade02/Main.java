package org.aptech.javade02;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        //Cake cake1 = new Cake("banh gato", 2.0); //cannot init an object from abstract class
        //Cake cake2 = new Cake("banh xx", 3.0);
        //System.out.println("name is "+cake1.name);
        //Hai cau dau tu lam
        ArrayList<Cake> cakes = new ArrayList<>();
        cakes.add(new OrderCake("name 1", 2.0, 12.3));
        cakes.add(new OrderCake("name 2", 1.0, 22.3));
        cakes.add(new ReadyMadeCake("name xx1", 3.0, 10));
        cakes.add(new ReadyMadeCake("name xx3", 5.0, 12));
        cakes.add(new OrderCake("name 3", 2.0, 42.2));
        cakes.add(new ReadyMadeCake("name xx4", 1.0, 13));
        cakes.add(new OrderCake("name 4", 1.0, 14.3));
        double totalPrice = 0.0;
        double totalPriceOrderCake = 0.0;
        double totalPriceReadyMadeCake = 0.0;

        int quantityOfOrderCake = 0;
        int quantityOfReadyMadeCake = 0;
        for (Cake cake: cakes) {
            totalPrice += cake.calculatePrice();
            if(cake instanceof OrderCake) {
                totalPriceOrderCake += cake.calculatePrice();
                quantityOfOrderCake++;
            } else if(cake instanceof ReadyMadeCake) {
                totalPriceReadyMadeCake += cake.calculatePrice();
                quantityOfReadyMadeCake++;
            }
        }
        System.out.println(
                "totalPrice = "+totalPrice+"\n"+
                "totalPriceOrderCake = "+totalPriceOrderCake+"\n"+
                "totalPriceReadyMadeCake = "+totalPriceReadyMadeCake+"\n"+
                "quantityOfOrderCake = "+quantityOfOrderCake+"\n"+
                "quantityOfReadyMadeCake = "+quantityOfReadyMadeCake+"\n"
        );
        double maxPrice = Double.MIN_VALUE;
        //find max
    }
}