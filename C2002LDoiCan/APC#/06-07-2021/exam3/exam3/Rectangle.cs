using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace exam3
{
    class Rectangle: Shape
    {
        private double width;
        private double height;
        public double Width { 
            get {
                return width;
            } set {
                width = value;
            } 
        }
        public double Height
        {
            get
            {
                return height;
            }
            set
            {
                height = value;
            }
        }
        public override void ShowArea()
        {
            Console.WriteLine($"area = ");
        }
    }
}
