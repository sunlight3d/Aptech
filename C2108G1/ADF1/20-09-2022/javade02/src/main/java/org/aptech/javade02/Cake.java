package org.aptech.javade02;

public abstract class Cake {
    protected String name;
    protected double rate;

    public Cake(){

    }
    public Cake(String name, double rate) {
        this.name = name;
        this.rate = rate;
    }
    /*
    public double calculatePrice() {
        //cannot do this, because insufficient fields
        return 0;
    }
    */
     //abstract = unfinished
    public abstract double calculatePrice();//abstract method cannot be "private"
    @Override
    public String toString() {
        return "Cake{" +
                "name='" + name + '\'' +
                ", rate=" + rate +
                '}';
    }
}
