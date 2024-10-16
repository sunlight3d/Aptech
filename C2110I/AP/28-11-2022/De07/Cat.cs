using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace De07
{
    internal class Cat : Animal
    {
        public string Color { get; set; }
        public Cat() {
            Name = "";
            Weight = 0.0f;
            Color = "white";
        }
        public Cat(string color, string name, float weight)
            : base(name, weight) { 
            this.Color = color;
        }

        public override void DisplayData()
        {
            Console.WriteLine($"Name: ${Name}," +
                              $"Weight: ${Weight}" +
                              $"Color: ${Color}");
        }

        public override void InputData()
        {
            Console.WriteLine("Enter name: ");
            this.Name = Console.ReadLine() ?? "";

            Console.WriteLine("Enter weight: ");
            this.Weight = (float)Convert.ToDouble(Console.ReadLine());

            Console.WriteLine("Enter color: ");
            this.Color = Console.ReadLine() ?? "";


        }
    }
}
