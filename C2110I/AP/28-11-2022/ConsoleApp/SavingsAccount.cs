using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp
{
    class SavingsAccount    
    {
        private static float annualInterestRate; //ANNUAL_INTEREST_RATE
        public float savingsBalance;
        
        public float MonthlyInterest { get {
                savingsBalance += annualInterestRate / 12;
                return annualInterestRate / 12;
            } 
        }
        public static float AnnualInterestRate { 
            set {
                annualInterestRate = annualInterestRate > 0 ? value : annualInterestRate;
            } 
        }
        public float SavingsBalance {
            get => savingsBalance;
            set {
                savingsBalance = savingsBalance > 0 ? value : savingsBalance;                
            }
        }
        private static int x = 1;
        private int y = 10; //instance field/attribute
        public void DoSomething() {
            x = 2;//ok, instance method can access static fields
        }
        public static void DoSomething2() {
            //y = 30;// NO!
            
        }
    }
}
