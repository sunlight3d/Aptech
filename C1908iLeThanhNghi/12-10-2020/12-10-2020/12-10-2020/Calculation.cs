using System;
using System.Collections.Generic;
using System.Text;

namespace _12_10_2020
{
    public class Calculation : IMath<double>
    {
        public double add(double a, double b)
        {
            return a + b;
        }

        public double substract(double a, double b)
        {
            return a - b;
        }
    }
}
