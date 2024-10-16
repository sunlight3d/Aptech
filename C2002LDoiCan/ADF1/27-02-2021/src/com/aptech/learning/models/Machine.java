package com.aptech.learning.models;

import java.util.Date;

public class Machine extends Product{
    private Integer warrantyTime;//month
    private Double power;
    @Override
    public Double getVat() {
        return 10.0/100.0;
    }
    @Override
    //viet doan code nay dep hon?
    public SellableStatus getSellableStatus() {
        /*
        Boolean isDifficult = this.getAmount() > 3;
        if(isDifficult){
            return SellableStatus.DIFFICULT;
        }
        return SellableStatus.EASY;
        */
        return this.getAmount() > 3 ? SellableStatus.DIFFICULT:SellableStatus.EASY;
    }


}
