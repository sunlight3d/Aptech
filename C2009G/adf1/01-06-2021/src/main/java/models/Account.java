package models;

import java.text.NumberFormat;

public class Account {
    public static final Float FEE = 2.0f;

    private long accountNumber;
    private String accountName;
    private double balance;
    private final Float interestRate = 0.035f;
    //default constructor
    public Account() {

    }
    public Account(long accountNumber, String accountName) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = 50;
    }
    public void deposit(Float money) {
        this.balance += money;
    }
    public boolean canWithdraw(float money) {
      return this.balance - money - FEE >= 0;
    }
    public void widthdraw(Float money) {
        //check
        if(!this.canWithdraw(money)) {
            System.err.println("Cannot withdraw money");
            return;
        }
        this.balance = this.balance - money - FEE;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    private String convertToCurrencyFormat(double money){
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String moneyString = formatter.format(money);
        return moneyString;
    }
    public void transferTo(Account anotherAccount, float money) {
        if(this.canWithdraw(money) == true) {
            this.widthdraw(money);
            anotherAccount.deposit(money);
        } else {
            System.err.println("Cannot withdraw from source account");
        }
    }
    public void maturity(){
        this.balance += interestRate * this.balance;
    }
    @Override
    public String toString() {
        return String.format("accountNumber= %d, accountName= %s, balance= %s",
                this.accountNumber, this.accountName, convertToCurrencyFormat(this.balance));
    }
}
