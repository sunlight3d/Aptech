using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace De07
{
    internal abstract class Animal
    {
        public string Name { get; set; }
        public float Weight { get; set; }
        public Animal() { } //default constructor, no-args constructors
        //lombok(Java)
        public abstract void InputData();
        public abstract void DisplayData();

    }
}
