using System;
namespace Aptech.Models
{
    public class Manager : Employee, ITax
    {
        public double Bonus { get; set; }
        public void CalculateTax()
        {
            Bonus = Salary * 0.2;
            double tax = Salary * 0.1;
            Salary += Bonus - tax;                
        }
        public override void Display()
        {
            base.Display();
            Console.WriteLine($"Bonus = {Bonus}, Salary = {Salary}");
        }
    }
}

