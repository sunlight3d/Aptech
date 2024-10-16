package com.product;

public abstract class Product {
    protected String productId;//fields, attributes
    protected String productName;
    protected int year;
    protected float price;
    public abstract void input();
    public abstract void display();
    public Product() {
    }

    public Product(String productId, String productName,
                   int year, float price) {
        this.productId = productId;
        this.productName = productName;
        this.year = year;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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
