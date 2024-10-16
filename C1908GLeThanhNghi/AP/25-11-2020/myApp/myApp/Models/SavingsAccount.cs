using System;
using System.Collections.Generic;
using System.Text;

namespace myApp.Models
{
    public class SavingsAccount
    {
        public static double annualInterestRate;
        private float savingsBalance;
        public float SavingsBalance { get {
                return savingsBalance;
            } 
            set {
                savingsBalance = value;
            } 
        }
        public double CalculateMonthlyInterest() =>
            annualInterestRate * savingsBalance / 12.0;
        public static void ModifyInterestRate(double newValue) {
            annualInterestRate = newValue;
        }

    }
}
