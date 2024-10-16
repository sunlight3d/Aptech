using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace APDe07
{
    public class Cat : Animal
    {
        public string Color { get; set; }
        public Cat(): base() { 
            Color = "white";
        }
        public Cat(string color, string name, double weight) : base(name, weight) { 
            Color = color;
        }
        public override void Display()
        {
            Console.WriteLine(
                $"color: {Color},\n"+
                $"name: {Name},\n" +
                $"weight: {Weight},\n"
                );
        }

        public override void InputData()
        {
            throw new NotImplementedException();
        }
    }
}
