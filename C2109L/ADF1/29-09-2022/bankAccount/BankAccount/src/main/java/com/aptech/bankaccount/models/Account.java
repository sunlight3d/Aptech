package com.aptech.bankaccount.models;

import java.util.ArrayList;

public abstract class Account {
    public static final String CHECKING = "CHECKING";
    public static final String SAVINGS = "SAVINGS";
    private long accountNumber;
    private long balance;
    private ArrayList<Transaction> transactionList = new ArrayList<>();

    public Account() {

    }

    public Account(long accountNumber, long balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }
    public abstract void withdraw(double amount);
    public void deposit(double amount) {
        this.balance += amount;
    }
    public void doWithdrawing(double amount) throws BankException {
        if(balance < amount) {
            throw new InsufficientFundsException(amount);
        }
        if(amount < 0) {
            throw new InvalidFundingAmountException(amount);
        }
        this.balance -= amount;
    }
    public void getTransactionHistory() {
        for (Transaction transaction: this.transactionList) {
            System.out.println(transaction);
        }
    }
    public void addTransaction(Transaction transaction) {
        this.transactionList.add(transaction);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof Account)) {
            return false;
        }
        //obj instance of Account
        Account other = (Account) obj;
        return other.accountNumber == this.accountNumber &&
                other.balance == this.balance;
    }
}
