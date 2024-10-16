using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp
{
    public class Mammal: Animal
    {
        //ko bat buoc override virtual method
        public override void Eat()
        {
            base.Eat();
            Console.WriteLine("Mammal eats...");
        }
        
    }
}
