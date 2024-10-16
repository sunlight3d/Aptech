package com.aptech.learning.models;

import java.util.Date;
import com.aptech.learning.models.*;
//jar = Java Archive
//war = Web Archive
//Food = "sub class" = lop con
public class Food extends Product {
    //Food  = "Product" + "some properties/methods" => ke thua(Inheritance)
    //Food chua cac thuoc tinh cua lop cha va them cac thuoc tinh cua rieng no
    private Date productionDate;
    private Date expiredDate;
    private String supplier;

    public Food(Integer productId, String productName, Integer amount, Double unitPrice,
                Date productionDate, Date expiredDate, String supplier) {
        super(productId, productName, amount, unitPrice);//goi constructor cua lop cha
        this.productionDate = productionDate;
        this.expiredDate = expiredDate;
        this.supplier = supplier;
        super.doSomething();//ok neu doSomething cua lop cha la public, default, protected
    }
    @Override
    public Double getVat() {
        return 5.0/100.0;
    }
    @Override
    protected void doSomething() {
        super.doSomething();

    }

    @Override
    public SellableStatus getSellableStatus() {
        Boolean isDifficult = this.getAmount() > 0 &&
                this.getExpiredDate().compareTo(new Date()) < 0;
        if(isDifficult){
            return SellableStatus.DIFFICULT;
        }
        return SellableStatus.EASY;
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
