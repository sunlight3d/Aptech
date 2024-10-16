using System;
using System.Collections.Generic;
using System.Text;

namespace _09_10_2020
{
    class Rectangle:Shape
    {
        public double Width { get; set; }
        public double Height { get; set; }

        public override void ShowArea()
        {
            Console.WriteLine($"Area = {Width * Height}");
        }
    }
}
