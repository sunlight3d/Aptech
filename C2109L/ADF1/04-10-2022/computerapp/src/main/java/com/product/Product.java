package com.product;

public abstract class Product {
    protected String prodId;
    protected String prodName;
    protected int year;
    protected float price;
    public Product() {

    }
    public Product(String prodId, String prodName,
                   int year, float price) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.year = year;
        this.price = price;
    }
    public abstract void input();
    public abstract void display();

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
