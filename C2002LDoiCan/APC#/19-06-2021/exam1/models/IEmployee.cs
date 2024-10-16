using System;
namespace exam1.models
{
    public interface IEmployee
    {
        public double CalculateBonus(string designation, int tenure, double salary);
        public void DisplayDetails();
    }
}
