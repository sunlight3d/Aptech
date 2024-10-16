using System;
using System.Collections.Generic;
using System.Text;

namespace myApp.Models
{
    public class Dog : Animal
    {
        public override void MakeSound()
        {
            Console.WriteLine("Gou Gou");
        }

        public override void Run()
        {
            Console.WriteLine("Dog is running");
        }

        public override void Sleep()
        {
            Console.WriteLine("Dog is sleeping");
        }
    }
}
