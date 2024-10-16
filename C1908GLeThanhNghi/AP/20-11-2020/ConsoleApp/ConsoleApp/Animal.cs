using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp
{
    public class Animal
    {
        public virtual void Eat() {
            Console.WriteLine("This is Eat method, virtual");
            //virtual = can override = overridable
        }
        public void DoSomething() {
            Console.WriteLine("Do something ....");
        }
    }
}
