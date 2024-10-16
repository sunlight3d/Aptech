package com.aptech.learning.models;

import java.time.Duration;
import java.util.Date;

public class Ceramic extends Product{
    private String producer;
    private Date inventoryDate;

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
    public Double getVat() {
        return 10.0/100.0;
    }
@Override
    //viet doan code nay dep hon?
    public SellableStatus getSellableStatus() {
    long diff = (new Date()).getTime() - this.inventoryDate.getTime()
            / (1000 * 60 * 60 * 24);
        return this.getAmount() > 50 && diff > 10
                ? SellableStatus.DIFFICULT:SellableStatus.EASY;
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
