using System;
using System.Collections.Generic;
using System.Text;

namespace _25_09_2020.models
{
    public class Car
    {
        public Car(string name, int maxSpeed)
        {
            this.name = name;
            this.maxSpeed = maxSpeed;
        }
        private string name;//field 
        private int maxSpeed = 1000;
        public string Name { //properties
            get {
                Console.WriteLine("getter");
                return name;
            }
            set {
                Console.WriteLine("setter");
                name = value;
            } 
       }
    }
}
