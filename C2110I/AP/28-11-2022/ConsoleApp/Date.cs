using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp
{
    internal class Date
    {
        public Date(int day, int month, int year) {
            Console.WriteLine($"{month}/{day}/{year}");
        }
        public Date(int day, string month, int year)
        {
            Console.WriteLine($"{month} {day}, {year}");
        }
    }
}
