using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EmployeeApp
{
    internal class NewEmployee:Employee
    {
        public override double CalculateBonus(string designation, int tenure, double salary) {
            if (designation.ToLower().Trim().Equals("teacher"))
            {
                return salary * (tenure <= 3 ? 3 : 4);
            }
            else {
                return base.CalculateBonus(designation, tenure, salary);
            }            
        }
        public void Input() {
            Console.WriteLine("Enter employee's nam: ");
            EmpName = Console.ReadLine() ?? "";
            Console.WriteLine("Select the designation(1-4)");
            Console.WriteLine("1 - Manager");
            Console.WriteLine("2 - Engineer");
            Console.WriteLine("3 - Technician");
            Console.WriteLine("4 - Teacher");
            Console.WriteLine("Enter the choice: ");
            int choice = int.Parse(Console.ReadLine() ?? "1");
            designation = choice == 1 ? "manager" :
                            (choice == 2 ? "engineer" :
                            (choice == 3 ? "technician" :
                            (choice == 4 ? "teacher" : "unknown")));
            salary = choice == 1 ? 5000 :
                            (choice == 2 ? 4000 :
                            (choice == 3 ? 3000 :
                            (choice == 4 ? 2000 : 0)));

            Console.WriteLine("Enter years of service: ");
            YearsOfService = int.Parse(Console.ReadLine() ?? "1");
            _bonus = CalculateBonus(designation, YearsOfService, salary);
        }
        public override string ToString()
        {
            return $"Employee name: {EmpName}, \n" +
                $"designation: {designation}, \n" +
                $"Salary: {salary}, \n" +
                $"Bonus: {_bonus}, \n" +
                $"Total income: {salary + _bonus}";
                
        }
    }
}
