using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp.Models
{
    internal class Student
    {
        public string RollNumber { get; set; }
        public string Name { get; set; }
        public string Address { get; set; }
        public int Age { get; set; }
        public void Input() {
            Console.WriteLine("Enter Roll number:");
            RollNumber = Console.ReadLine() ?? ""; //default value(C#, js)
            
            Console.WriteLine("Enter name:");
            Name = Console.ReadLine() ?? "";

            Console.WriteLine("Enter address:");
            Address = Console.ReadLine() ?? "";

            Console.WriteLine("Enter age:");
            Age = Convert.ToInt32(Console.ReadLine());
            Age = Age < 18 ? 18 : Age;

        }
        public override string ToString()
        {
            return  $"RollNumber: {RollNumber}"+
                    $"Name: {Name}" +
                    $"Address: {Address}" +
                    $"Age: {Age}"
                ;
        }
    }
}
