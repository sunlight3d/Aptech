using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp.Utilities
{
    public class Calculation
    {
        public static int Sum(int x, int y) { 
            return x + y; 
        }
        //overload
        public static float Sum(float x, float y)
        {
            return x + y;
        }
        public static double Sum(float x, float y, float z) => x + y + z;
        public static void SayHello(string? name) {
            if (!string.IsNullOrEmpty(name))
            {
                Console.WriteLine(name);
            }
            else { 
                Console.WriteLine("Nothing to show");
            }            
        }
        public static void Display(string? color, string message = "Nothing") { 
            Console.WriteLine($"message is {message}, color is {color}");
        }
        
    }
}
