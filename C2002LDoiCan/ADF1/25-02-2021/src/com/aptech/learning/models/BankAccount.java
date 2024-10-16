package com.aptech.learning.models;

public class BankAccount {
    public static final Double INITIAL_INTEREST_RATE = 0.035;
    private long accountNumber;
    private String accountName;
    private Double balance;
    private Double interestRate = INITIAL_INTEREST_RATE;
    //default constructor = constructor without parameters
    public BankAccount(){
        //constructor'name = class' name
    }

    public BankAccount(long accountNumber, String accountName, Double balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }
    public BankAccount(long accountNumber, String accountName) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = 50.0;
    }
    public void addCash(Double amount) {
        this.balance += amount;
    }
    public void withdraw(Double amount, Double fee){
        this.balance = (this.balance - amount - fee) < 0 ? this.balance :
                        this.balance - amount - fee;
    }
    public void updateExpiredDate() {
        this.balance = (1 + this.interestRate) * this.balance;
    }
    public void transferMoney(BankAccount nextAccount, Double amount) {
        if(this.balance - amount < 0) {
            System.out.println("Cannot transfer money");
            return;
        }
        this.withdraw(amount, 0.0);
        nextAccount.addCash(amount);//ko can kiem tra
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

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber=" + accountNumber +
                ", accountName='" + accountName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
