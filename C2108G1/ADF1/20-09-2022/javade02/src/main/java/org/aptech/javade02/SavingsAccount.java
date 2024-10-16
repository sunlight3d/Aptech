package org.aptech.javade02;

public class SavingsAccount {
    private Double balance;

    public Double getBalance() {
        return balance;
    }

    public SavingsAccount(Double balance) {
        this.balance = balance;
    }
    private static Float ANNUAL_INTEREST_RATE = 0.15f;
    public Double calculateMonthlyInterest() {
        double interestRate = balance * ANNUAL_INTEREST_RATE / 12.0;
        balance += interestRate;//danger !
        return interestRate;
    }
    public static void modifyInterestRate(Float newValue) {
        ANNUAL_INTEREST_RATE = newValue;
    }
}
