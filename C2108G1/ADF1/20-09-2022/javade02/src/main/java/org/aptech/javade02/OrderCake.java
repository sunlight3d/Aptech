package org.aptech.javade02;

public class OrderCake extends Cake{
    private Double weight;

    public OrderCake(String name, double rate, Double weight) {
        super(name, rate);//call constructor of Cake
        this.weight = weight;
    }

    @Override
    public double calculatePrice() {
        return weight * rate;
    }
    @Override
    public String toString() {
        return super.toString() + "\n"+
                "weight=" + weight;
    }
}
