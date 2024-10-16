using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exam4
{
    public class EmployeeTest
    {
        public void Input()
        {
            NewEmployee newEmployee= new NewEmployee();
            Console.WriteLine("Enter the employee name: ");
            newEmployee.EmpName = Console.ReadLine();
            while(true)
            {
                Console.WriteLine("Select the designation(1-4)");
                Console.WriteLine("1 - Manager");
                Console.WriteLine("2 - Engineer");
                Console.WriteLine("3 - Technician");
                Console.WriteLine("4 - Teacher");
                Console.WriteLine("Enter your choice: ");
                string choice = Console.ReadLine().Trim();
                string[] stringArray = { "1", "2", "3", "4" };
                if (Array.IndexOf(stringArray, choice) > -1)
                {
                    /*
                    newEmployee.Designation = choice.Equals("1") ? "Manager" :
                        (choice.Equals("2") ? "Engineer" : (
                            choice.Equals("3") ? "Technician" : (
                            choice.Equals("4") ? "Teacher" : ""
                            )
                        ));
                    newEmployee.Salary = choice.Equals("1") ? 5000 :
                        (choice.Equals("2") ? 4000 : (
                            choice.Equals("3") ? 3000 : (
                            choice.Equals("4") ? 2000 : 0
                            )
                        ));
                    */
                    if(choice.Equals("1"))
                    {
                        newEmployee.Designation = "Manager";
                        newEmployee.Salary = 5000;
                    }else if (choice.Equals("2"))
                    {
                        newEmployee.Designation = "Engineer";
                        newEmployee.Salary = 4000;
                    } else if (choice.Equals("3"))
                    {
                        newEmployee.Designation = "Technician";
                        newEmployee.Salary = 3000;
                    } else if (choice.Equals("4"))
                    {
                        newEmployee.Designation = "Teacher";
                        newEmployee.Salary = 2000;
                    }
                    break;
                }
                else {
                    Console.WriteLine("Invalid option selected");
                }
            }
            Console.WriteLine("Enter years of service: ");
            newEmployee.YearsOfService = Convert.ToInt32(Console.ReadLine());
            newEmployee.DisplayDetails();
        }
    }
}
