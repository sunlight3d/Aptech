using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp
{
    public class FlashLamp
    {
        public bool Status{ get; set; }
        public List<Battery> bateries = new List<Battery>();//ok, ko bat buoc 
        public void CheckLight() {
            if (Status == true)
            {
                Console.WriteLine("Light is on");
            }
            else {
                Console.WriteLine("Light is off");
            }
        }
        public void TurnOn() {
            this.Status = true;
        }

        public void TurnOff()
        {
            this.Status = false;
        }

    }
}
