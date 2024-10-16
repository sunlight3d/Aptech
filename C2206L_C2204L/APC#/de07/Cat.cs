using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace de07
{
    internal class Cat : Animal
    {
        public string Color { get; set; }
        public Cat():base() { 
            Color= "";
            Name = "";
            Weight = 1;
        }
        public Cat(string name, double weight, string color) : base() { 
            Name = name;
            Weight = weight;
            Color = color;
        }
        public override void DisplayData()
        {
            Console.WriteLine(
                $"name: {Name}, " +
                $"weight: {Weight}"+
                $"color: {Color}"
                );
        }

        public override void InputData()
        {
            Console.WriteLine("Enter name: ");
            Name = Console.ReadLine();

            Console.WriteLine("Enter weight: ");
            Weight = double.Parse(Console.ReadLine());

            Console.WriteLine("Enter color: ");
            Color = Console.ReadLine();
        }
        public override string ToString()
        {
            return $"name: {Name}, weight: {Weight}, color: {Color}";
        }
    }
}
