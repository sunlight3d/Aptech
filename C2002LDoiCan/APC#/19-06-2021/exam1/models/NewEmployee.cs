using System;
namespace exam1.models
{
    public class NewEmployee : Employee
    {
        public override double CalculateBonus(string designation, int tenure, double salary)
        {
            if (designation == "Teacher")
            {
                return tenure <= 3 ? salary * 3 : salary * 4; 
            }
            else {
                return base.CalculateBonus(designation, tenure, salary); //base = super of Java 
            }            
        }

        public override void DisplayDetails()
        {
            base.DisplayDetails();
        }
    }
}
