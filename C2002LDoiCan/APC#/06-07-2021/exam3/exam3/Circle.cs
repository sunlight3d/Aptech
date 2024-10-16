using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace exam3
{
    class Circle : Shape
    {
        private double radius;
        public double Radius { 
            get {
                return radius;
            }
            set {
                radius = value;
            } 
        }
        public override void ShowArea()
        {
            Console.WriteLine("Area = {Math.Pow(radius, 2) * Math.PI}");
        }
    }
}
