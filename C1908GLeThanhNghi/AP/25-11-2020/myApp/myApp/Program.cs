using myApp.Models;
using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace myApp
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Test rectangle");
            Rectangle r1 = new Rectangle()
            {
                Length = 100.0f,
                Width = 200.0f  
            };
            Rectangle r2 = new Rectangle()
            {
                Length = 10.0f,
                Width = 10.0f,
            };
            Assert.AreEqual(r1.Length, 0.0f);
            Assert.AreEqual(r2.Length, 10.0f);
            SavingsAccount saver1 = new SavingsAccount()
            {
                SavingsBalance = 2000
            };
            SavingsAccount saver2 = new SavingsAccount()
            {
                SavingsBalance = 3000
            };
            SavingsAccount.ModifyInterestRate(4.0 / 100);
            Console.WriteLine($"interest rate s1 = {saver1.CalculateMonthlyInterest()}");
            Console.WriteLine($"interest rate s2 = {saver2.CalculateMonthlyInterest()}");
            Date date1 = new Date(22, 11, 2020);
            date1.Month = 12;
            Console.WriteLine(date1.ToMMDDYYYY());
            Console.WriteLine(date1.ToMMdd_yyyy());
        }
    }
}
