using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace de03
{
    internal class EmployeeTest
    {
        public static void Test() {
            NewEmployee newEmployee = new NewEmployee();
            Console.WriteLine("Enter the employee's name: ");
            newEmployee.EmployeeName = Console.ReadLine() ?? "";            
            int choice = 0;            
            while (choice < 1 || choice > 4) {
                Console.WriteLine("Select the designation(1-4): ");
                Console.WriteLine("1 - Manager");
                Console.WriteLine("2 - Engineer");
                Console.WriteLine("3 - Technician");
                Console.WriteLine("4 - Teacher");
                Console.WriteLine("Enter the choice: ");
                choice = int.Parse(Console.ReadLine() ?? "1");
                if (choice == 1)
                {
                    newEmployee.designation = "Manager";
                    newEmployee.salary = 1234;
                }
                else if (choice == 2)
                {
                    newEmployee.designation = "Engineer";
                    newEmployee.salary = 5643;
                }
                else if (choice == 3)
                {
                    newEmployee.designation = "Technician";
                    newEmployee.salary = 3223;
                }
                else if (choice == 4)
                {
                    newEmployee.designation = "Teacher";
                    newEmployee.salary = 4442;
                }                                
            }
            Console.WriteLine("Enter the years of service: ");
            newEmployee.YearOfService = int.Parse(Console.ReadLine() ?? "0");
            
            newEmployee.DisplayDetails();

        }
    }
}
