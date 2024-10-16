package com.ab5tract.example;

public class Motobike extends Vehicle{
    private boolean hasSideCar;

    public Motobike(String  brand,
                    String  model,
                    String  registrationNumber,
                    Person  owner,
                    boolean hasSideCar
    ) {
        super(brand, model, registrationNumber, owner);
        this.hasSideCar = hasSideCar;
    }

    public boolean isHasSideCar() {
        return hasSideCar;
    }

    public void setHasSideCar(boolean hasSideCar) {
        this.hasSideCar = hasSideCar;
    }
}
