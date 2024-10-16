using System;
using exam1.models;
namespace exam1.test
{
    public class EmployeeTest
    {
        public void Test()
        {
            NewEmployee mrA = new NewEmployee()
            {
                //builder pattern                
                Salary = 2000,                
            };
            Console.WriteLine("Enter the employee name: ");
            mrA.EmpName = Console.ReadLine();
            int choice = 0;
            do
            {
                Console.WriteLine("Select the designation(1-4)");
                Console.WriteLine("1 - Manager");
                Console.WriteLine("2 - Engineer");
                Console.WriteLine("3 - Technician");
                Console.WriteLine("4 - Teacher");

                Console.WriteLine("Enter your choice: ");
                choice = Convert.ToInt32(Console.ReadLine());
                switch (choice) {
                    case 1:
                        mrA.Desination = "Manager";
                        Console.WriteLine($"Designation is {mrA.Desination} and Salary is {mrA.Salary}");
                        break;
                    case 2:
                        mrA.Desination = "Engineer";
                        Console.WriteLine($"Designation is {mrA.Desination} and Salary is {mrA.Salary}");
                        break;
                    case 3:
                        mrA.Desination = "Technician";
                        Console.WriteLine($"Designation is {mrA.Desination} and Salary is {mrA.Salary}");
                        break;
                    case 4:
                        mrA.Desination = "Teacher";
                        Console.WriteLine($"Designation is {mrA.Desination} and Salary is {mrA.Salary}");
                        break;
                    default:
                        Console.WriteLine("Invalid option selected");
                        break;
                }
            } while (choice >= 1 && choice <= 4);

        }
    }
}
