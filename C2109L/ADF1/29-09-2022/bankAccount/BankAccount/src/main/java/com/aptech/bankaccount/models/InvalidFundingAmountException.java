package com.aptech.bankaccount.models;

public class InvalidFundingAmountException extends BankException{
    private double amount;
    public InvalidFundingAmountException(String message) {
        super(message);
    }
    public InvalidFundingAmountException(double amount) {
        super("InvalidFundingAmountException : "+amount);
        this.amount = amount;
    }
}
