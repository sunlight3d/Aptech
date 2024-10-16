using System;
using System.Collections.Generic;
using System.Text;

namespace myApp.Models
{
    public class People:Animal
    {
        public string Address { get; set; }
        public string TelephoneNumber { get; set; }        
        public void Learn() { 

        }
        public override void MakeSound()
        {
            Console.WriteLine("Hello");
        }

        public override void Run()
        {
            Console.WriteLine("people is running");
        }

        public override void Sleep()
        {
            Console.WriteLine("people is sleeping");
        }
    }
}
