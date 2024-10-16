using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace De03
{
    internal class EmployeeTest
    {
        public void TestEmployees() {
            Console.WriteLine("Enter the employee name: ");
            string employeeName = Console.ReadLine() ?? "";
            NewEmployee newEmployee = new NewEmployee() { 
                EmpName = employeeName
            };
            Console.WriteLine("Select the designation(1, 4)");
            Console.WriteLine("1. Manager");
            Console.WriteLine("2. Engineer");
            Console.WriteLine("3. Technician");
            Console.WriteLine("4. Teacher");
            Console.WriteLine("Enter your choice:");
            int choice = Convert.ToInt32(Console.ReadLine());

            Console.WriteLine("Enter year of services:");
            int yearOfService = Convert.ToInt32(Console.ReadLine());
            switch (choice)
            {
                case 1:
                    newEmployee.CalculateBonus("Manager", yearOfService, 5000);
                    break;
                case 2:
                    newEmployee.CalculateBonus("Engineer", yearOfService, 4000);
                    break;
                case 3:
                    newEmployee.CalculateBonus("Technician", yearOfService, 3000);
                    break;
                case 4:
                    newEmployee.CalculateBonus("Teacher", yearOfService, 2000);
                    break;
                default:
                    Console.WriteLine("Please choose 1-4");
                    break;

            }
            newEmployee.DisplayDetails();
        }
    }
}

