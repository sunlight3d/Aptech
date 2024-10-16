package com.aptech.bankaccount.models;

public class Transaction {
    public static final int TYPE_DEPOSIT_CHECKING = 1;
    public static final int TYPE_WITHDRAW_CHECKING = 2;
    public static final int TYPE_DEPOSIT_SAVINGS = 3;
    public static final int TYPE_WITHDRAW_SAVINGS = 4;
    private int type;
    private double amount;
    private double initialBalance;
    private double finalBalance;

    public Transaction(int type, double amount,
                       double initialBalance, double finalBalance) {
        this.type = type;
        this.amount = amount;
        this.initialBalance = initialBalance;
        this.finalBalance = finalBalance;
    }
    public String getTransactionTypeString(int type) {
        switch (type) {
            case TYPE_DEPOSIT_CHECKING -> {
                return "TYPE_DEPOSIT_CHECKING";
            }
            case TYPE_WITHDRAW_CHECKING -> {
                return "TYPE_WITHDRAW_CHECKING";
            }
            case TYPE_DEPOSIT_SAVINGS -> {
                return "TYPE_DEPOSIT_SAVINGS";
            }
            case TYPE_WITHDRAW_SAVINGS -> {
                return "TYPE_WITHDRAW_SAVINGS";
            }
        }
        return  "Nothing";
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "type=" + type +
                ", amount=" + amount +
                ", initialBalance=" + initialBalance +
                ", finalBalance=" + finalBalance +
                '}';
    }
}
