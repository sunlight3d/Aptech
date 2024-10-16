using System;
namespace Aptech.Models
{
    public class Employee: Person
    {
        public double Salary { get; set; }
        public void IncreaseSalary(int x) {
            Salary += x;
        }
        
        public void IncreaseSalary(double x)
        {
            Salary *= x;
        }
        public override void Display()
        {
            base.Display();
            Console.WriteLine($"Salary = {Salary}");
        }
    }
}

