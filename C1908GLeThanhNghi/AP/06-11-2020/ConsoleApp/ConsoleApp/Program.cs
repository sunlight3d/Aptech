using System;

namespace ConsoleApp
{
    class Program
    {
        static void Main(string[] args)
        {
            //Test getter / setter in C#
            /*
            Employee mrHoang = new Employee()
            {
                Name = "Hoang",
                Id = "123"
            };
            mrHoang.Name = "Abcxy";
            Console.WriteLine($"Name = {mrHoang.Name}");
            */              
            EmployeeManagement employeeManagement = new EmployeeManagement();
            employeeManagement.CreateMenu();              
        }
    }
}
