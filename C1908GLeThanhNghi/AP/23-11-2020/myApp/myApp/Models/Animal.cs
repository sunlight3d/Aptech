using System;
using System.Collections.Generic;
using System.Text;

public enum FoodType {
    Herbivore, //An co 
    Carnivore, //An thit
    Omnivore
}
namespace myApp.Models
{
    public abstract class Animal
    {
        public string Name { get; set; }
        public int Age { get; set; }
        public FoodType FoodType { get; set; }
        public abstract void Run();
        public abstract void Sleep();
        public abstract void MakeSound();
    }
}
