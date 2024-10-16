package com.aptech.bankaccount.models;

public class SavingsAccount extends Account{
    public SavingsAccount(long accountNumber, long balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) {

    }

    @Override
    public void deposit(double amount) {

    }
}
