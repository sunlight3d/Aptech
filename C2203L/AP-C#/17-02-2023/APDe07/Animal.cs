using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace APDe07
{
    public abstract class Animal
    {
        public string Name { get; set; }
        public double Weight { get; set; }
        public Animal() {
            Name = "";
            Weight= 0.0;
        }
        public Animal(string name, double weight)
        {
            Name = name;    
            Weight = weight;
        }
        //abstract methods
        public abstract void InputData();
        public abstract void Display();
    }
}
