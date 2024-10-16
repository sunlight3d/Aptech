package com.aptech.learning.models;

import java.util.Date;

public class Ceramic extends Product{
    private String producer;
    private Date inventoryDate;
    {
        super.setVat(10.0/100.0);
    }
    public Ceramic(String producer, Date inventoryDate) {
        this.producer = producer;
        this.inventoryDate = inventoryDate;
    }

    public Ceramic(Integer productId, String productName, Integer amount, Double unitPrice,
                   String producer, Date inventoryDate) {
        super(productId, productName, amount, unitPrice);
        this.producer = producer;
        this.inventoryDate = inventoryDate;
    }

    @Override
    protected void doSomething() {
        super.doSomething();
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Date getInventoryDate() {
        return inventoryDate;
    }

    public void setInventoryDate(Date inventoryDate) {
        this.inventoryDate = inventoryDate;
    }
}
