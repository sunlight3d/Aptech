using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace De07
{
    public abstract class Animal
    {
        [Key]
        public string Name { get; set; }
        public double Weight { get; set; }
        public Animal() { }
        public Animal(string name, double weight)
        {
            Name = name;
            Weight= weight;               
        }
        public virtual void InputData() {
            Console.WriteLine("Enter name: ");
            Name = Console.ReadLine() ?? "";

            Console.WriteLine("Enter weight: ");            
            Weight = Convert.ToDouble(Console.ReadLine());
        }
        public virtual void DisplayData() {
            Console.WriteLine($"Name : {Name},\n"+$"Weight: {Weight}");
        }
    }
}
