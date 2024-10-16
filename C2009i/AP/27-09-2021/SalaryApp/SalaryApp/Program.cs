using Aptech.Models;
namespace SalaryApp
{
     public class Program
    {
        public static void Main(string[] args)
        {
            Manager managerA = new Manager()
            {
                Name = "manager A",
                Age = 30,
                Salary = 111,                
            };
            managerA.CalculateTax();
            Manager managerB = new Manager()
            {
                Name = "manager A",
                Age = 30,
                Salary = 111,
            };
            managerB.CalculateTax();
            Manager managerC = new Manager()
            {
                Name = "manager A",
                Age = 30,
                Salary = 111,
            };
            managerC.CalculateTax();
            List<Person> persons = new List<Person>()
            {
                managerA, managerB, managerC    
            };
            //old way: iterate the list, find max salary
            //iterate a list, display objects with max value
            //O(n) = 2*n

        }
    }

}
