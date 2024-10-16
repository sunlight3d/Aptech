package com.aptech.bankaccount.models;

public class InsufficientFundsException extends BankException{
    private double amount;
    public InsufficientFundsException(String message) {
        super(message);
    }
    public InsufficientFundsException(double amount) {
        super("InsufficientFundsException : "+amount);
        this.amount = amount;
    }
}
