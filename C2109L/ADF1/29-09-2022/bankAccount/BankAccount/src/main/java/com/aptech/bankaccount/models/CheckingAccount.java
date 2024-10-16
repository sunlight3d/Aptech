package com.aptech.bankaccount.models;


public class CheckingAccount extends Account{
    public CheckingAccount(long accountNumber, long balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) {
        try {
            this.doWithdrawing(amount);
        }catch (BankException e) {

        }
    }

}