using System;
namespace Aptech.Models
{
    public class Person
    {
        public string Name { get; set; }
        public int Age { get; set; }
        public virtual void Display() //virtual = inheritable/can be extended           
        {           
            Console.WriteLine($"name: {Name}, age: {Age}");
        }
        public void Input() //virtual - can be inherit
            
        {
            Console.WriteLine("Enter name: ");
            Name = Console.ReadLine() ?? "";
            Console.WriteLine("Enter age: ");
            Age = Convert.ToInt32(Console.ReadLine());
        }
    }
}

