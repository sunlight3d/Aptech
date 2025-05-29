using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace de13
{
    public class Rectangle
    {
        private double width = 1.0;
        private double height = 1.0;
        public double Width {
            get { return width; }
            set {
                if (value >= 0 && value <= 20.0)
                {
                    width = value;
                    Console.WriteLine($"Area = {GetArea}, Perimeter = {GetPerimeter}");
                }
                else {
                    throw new ArgumentException("Width must be between 0.0 and 20.0");
                }
            }
       }

        public double Height
        {
            get { return height; }
            set
            {
                if (value >= 0 && value <= 20.0)
                {
                    height = value;
                }
                else
                {
                    throw new ArgumentException("Height must be between 0.0 and 20.0");
                }
            }
        }
        public double GetPerimeter => (width + height)*2.0;
        public double GetArea => width * height;
    }
}
