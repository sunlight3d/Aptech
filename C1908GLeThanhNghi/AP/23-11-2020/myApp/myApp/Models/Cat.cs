using System;
using System.Collections.Generic;
using System.Text;

namespace myApp.Models
{
    public class Cat : Animal
    {
        public override void MakeSound()
        {
            Console.WriteLine("Meo");
        }

        public override void Run()
        {
            Console.WriteLine("Cat is running");
        }

        public override void Sleep()
        {
            Console.WriteLine("Cat is sleeping");
        }
    }
}
