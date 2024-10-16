package org.aptech.javade02;
//1 parent/super class has many child classes: Yes!
/*
A child class has 2 parent classes ? NO!(Java), Yes(Python, C++)
Ex: HybridCar(Child) -> PetrolCar(parent) + ElectricCar(parent)
* */
public class ReadyMadeCake extends Cake{
    private int quantity;

    public ReadyMadeCake(String name, double rate, int quantity) {
        super(name, rate);
        this.quantity = quantity;
    }

    @Override
    public double calculatePrice() {
        return quantity * rate;
    }

    @Override
    public String toString() {
        return super.toString() + "\n"+
                "quantity=" + quantity;
    }
}
