using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace De07
{
    public class Cat : Animal
    {
        public string Color { get; set; }
        public Cat():base() {
            Color = "white";
        }
        public Cat( string name, double weight, string color) : base(name, weight)
        {
            Color = color;
        }
        public override void InputData() { 
            base.InputData();
            Console.WriteLine("Enter color: ");
            Color = Console.ReadLine() ?? "";
        }
        public override void DisplayData()
        {
            base.DisplayData();
            Console.WriteLine($"Color: {Color}");
        }
    }
}
