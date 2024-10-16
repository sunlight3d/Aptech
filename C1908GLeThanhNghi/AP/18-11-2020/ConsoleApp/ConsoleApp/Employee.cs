using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp
{
    public class Employee
    {
        private string name;
        public int Id { get; set; } //Properties
        //full getter/setter
        /*
        public string Name { 
            get {
                Console.WriteLine("This is getter");
                return name;
            } 
            set {
                Console.WriteLine("This is setter");
                name = value.ToUpper();
            } 
        }
        */
        public string Name { get; set; }
        public int WorkingDays { get; set; }
        public float DailySalary { get; set; }
        //factory method
        public static Employee InputEmployee()
        {
            Console.WriteLine("Enter id : ");
            int id = Convert.ToInt32(Console.ReadLine().Trim());
            Console.WriteLine("Enter name : ");
            string name = Console.ReadLine().Trim();
            Console.WriteLine("Enter workingDays : ");
            int workingDays = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("Enter dailySalary : ");
            float dailySalary = (float)Convert.ToDouble(Console.ReadLine());
            return new Employee()
            {
                Id = id, Name = name, 
                WorkingDays = workingDays, DailySalary = dailySalary
            };

        }

        public override string ToString()
        {
            return $"Name = {Name}, " +
                $"Id = {Id}, " +
                $"WorkingDays = {WorkingDays}, " +
                $"DailySalary = {DailySalary}";
        }
    }
}
