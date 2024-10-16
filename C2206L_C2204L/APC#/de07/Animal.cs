using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Runtime.InteropServices.JavaScript.JSType;

namespace de07
{
    abstract class Animal
    {
        public string Name { get; set; }
        public double Weight { get; set; }
        public Animal() { }
        public Animal(string name, double weight) {
            Name = name;    
            Weight = weight;
        }
        public abstract void InputData();
        public abstract void DisplayData();
    }    

}
