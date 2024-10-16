package com.aptech.learning.models;

import java.util.Date;
//jar = Java Archive
//war = Web Archive
//Food = "sub class" = lop con
public class Food extends Product {
    //Food  = "Product" + "some properties/methods" => ke thua(Inheritance)
    //Food chua cac thuoc tinh cua lop cha va them cac thuoc tinh cua rieng no
    private Date productionDate;
    private Date expiredDate;
    private String supplier;
    {
        //final giong "const" trong C
        super.setVat(10.0/100.0);
    }
    public Food(Integer productId, String productName, Integer amount, Double unitPrice,
                Date productionDate, Date expiredDate, String supplier) {
        super(productId, productName, amount, unitPrice);//goi constructor cua lop cha
        this.productionDate = productionDate;
        this.expiredDate = expiredDate;
        this.supplier = supplier;
        super.doSomething();//ok neu doSomething cua lop cha la public, default, protected
    }

    @Override
    protected void doSomething() {
        super.doSomething();

    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
}
