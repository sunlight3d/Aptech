package com.aptech.learning.models;
//lop cha = super class = base class
//final = const = "cannot be inherited/extended"

public abstract class Product {
    private Integer productId;
    private String productName;
    private Integer amount;
    private Double unitPrice;
    public Product() {

    }
    public Product(Integer productId, String productName,
                   Integer amount, Double unitPrice) {
        this.productId = productId;
        this.productName = productName;
        this.amount = amount;
        this.unitPrice = unitPrice;
        //TenClass.tenPhuongThucStatic()
        //tenDoiTuong.tenPhuongthucInstance
        //java.io = Input/Output
        //java.util = Utilities
        //java.awt = Abstract Windowing Toolkit
    }
    protected void doSomething() {
        System.out.println("dosomething in super class");
    }
    public Integer getProductId() {
        return productId;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }
    public abstract Double getVat();
    //abstract => phai co lop con implement ho
    //da abstract thi KO private
    public abstract SellableStatus getSellableStatus();

}
