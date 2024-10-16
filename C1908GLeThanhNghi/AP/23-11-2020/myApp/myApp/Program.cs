using System;
using System.Collections.Generic;

namespace myApp
{    
    class Program
    {        
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World!");
            //test singleton
            AnimalManager.getInstance();
            Stack stack = new Stack() {
                Numbers = new List<int>{ 1, 7, 8, 9 }
            };
            Console.WriteLine($"numbers at 2 = {stack[2]}");
            
        }
    }
}
