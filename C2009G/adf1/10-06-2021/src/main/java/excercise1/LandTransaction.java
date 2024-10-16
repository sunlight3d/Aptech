package excercise1;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;

public class LandTransaction extends Transaction{
    private LandType landType;
    public LandTransaction(){
        super();
    }

    public LandType getLandType() {
        return landType;
    }

    public void setLandType(LandType landType) {
        this.landType = landType;
    }

    @Override
    public Double getTotalPrice() {
        /*
        if(landType == LandType.A) {
            return this.getArea() * this.getUnitPrice() * 1.5;
        } else {
            return this.getArea() * this.getUnitPrice();
        }
        */
        //return landType == LandType.A ? this.getArea() * this.getUnitPrice() * 1.5 : this.getArea() * this.getUnitPrice(); //ok
        return this.getArea() * this.getUnitPrice() *(landType == LandType.A ? 1.5 : 1);
    }

    public LandTransaction(String transactionCode, Date transactionDate, Double unitPrice, Double area,
                           LandType landType) {
        super(transactionCode, transactionDate, unitPrice, area);
        this.landType = landType;
    }
    @Override
    public String toString() {
        return String.format("%s,landType = %s, address = %s", super.toString(),landType);
    }

    @Override
    public void input() {
        super.input();
        System.out.println("Enter landtype(a or b): ");
        String inputType = getScanner().next();
        //nhap string => Enum ?
        this.landType = inputType.toLowerCase().equals("a") ? LandType.A
                : (inputType.toLowerCase().equals("b") ? LandType.B : LandType.C);

    }
}
