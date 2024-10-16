package excercise1;

import helpers.DateTimeUtility;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

//parent class
public class Transaction {
    private String transactionCode;
    private Date transactionDate;
    private Double unitPrice;
    private Double area;
    //constructor
    public Transaction() {};

    public Transaction(String transactionCode,
                       Date transactionDate,
                       Double unitPrice,
                       Double area
                       ) {
        this.transactionCode = transactionCode;
        this.transactionDate = transactionDate;
        this.unitPrice = unitPrice;
        this.area = area;
    }

    public Double getTotalPrice(){
        return 0.0;
    }

    public Double getArea() {
        return area;
    }

    public void input() {
        System.out.println("Enter code: ");
        this.transactionCode = getScanner().next();

        System.out.println("Enter date(dd/mm/yyyy): ");
        this.transactionDate = DateTimeUtility.convertStringToDateTime(getScanner().next()); //phai co ham convert tu string sang Date

        System.out.println("Enter unit price: ");
        this.unitPrice = getScanner().nextDouble();

        System.out.println("Enter area: ");
        this.area = getScanner().nextDouble();
    }
    public void setArea(Double area) {
        this.area = area;
    }

    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Scanner getScanner() {
        //return scanner;//bug: scanner dung di dung lai => dinh dau enter
        //=> tao lai moi lan goi
        return new Scanner(System.in);
    }


    @Override
    public String toString() {
        return  String.format("transactionCode= %s,  transactionDate=%s, unitPrice=%f, area = %f\n",
                transactionCode, transactionDate, unitPrice, area);
    }
}
