package excercise1;

import java.time.LocalDateTime;
import java.util.Date;

public class HouseTransaction extends Transaction{
    private HouseType houseType;
    private String address;
    public HouseTransaction(){
        super();
    }
    //constructor
    public HouseTransaction(String transactionCode, Date transactionDate, Double unitPrice, Double area,
                            HouseType houseType, String address) {
        super(transactionCode, transactionDate, unitPrice, area);
        this.houseType = houseType;
        this.address = address;
    }
    @Override
    public Double getTotalPrice() {
        return this.getArea() * this.getUnitPrice() *(houseType == HouseType.VIP ? 1 : 0.9);
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public HouseType getHouseType() {
        return houseType;
    }

    public void setHouseType(HouseType houseType) {
        this.houseType = houseType;
    }

    @Override
    public String toString() {
        return String.format("%s,houseType = %s, address = %s", super.toString(),houseType, address);
    }
    @Override
    public void input() {
        super.input();
        System.out.println("Enter house type(normal or vip): ");
        //nhap string => Enum ?
        this.houseType = getScanner().next().toLowerCase().equals("vip") ? HouseType.VIP : HouseType.NORMAL;
    }

}
