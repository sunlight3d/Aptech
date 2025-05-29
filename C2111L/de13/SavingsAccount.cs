using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace de13
{
    internal class SavingsAccount
    {
        private static double annualInterestRate;
        private double savingsBalance;
        public double CalculateMonthlyInterest() { 
            return savingsBalance * (annualInterestRate / 12);
        }
        public static void ModifyInterestRate(double newRate) { 
            annualInterestRate = newRate;
        }
        public double SavingBalance { get => savingsBalance; set => savingsBalance = value; }
        public override string ToString()
        {
            return $"Saving balance: {SavingBalance}, monthly interest: {CalculateMonthlyInterest()}";
        }
    }
}
