package com.aptech.de02;

public class SavingsAccount {
    private static float annualInterestRate;
    private Double savingsBalance;

    public SavingsAccount(Double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    public Double calculateMonthlyInterest() {
        double interest = (annualInterestRate * savingsBalance)/12;
        this.savingsBalance += interest;
        return interest;
    }
    public static void modifyAnnualInterestRate(float newValue) {
        annualInterestRate = newValue;
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "savingsBalance=" + savingsBalance +
                '}';
    }
}
