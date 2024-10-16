using myApp.Models;
using System;
using System.Collections.Generic;
using System.Text;

namespace myApp
{
    public class AnimalManager
    {
        List<Animal> animals;
        private static AnimalManager instance;
        //Disallow call default constructor
        private AnimalManager() {
            Console.WriteLine("AnimalManager constructor");
        }
        public static AnimalManager getInstance() {
            if (instance == null) {
                instance = new AnimalManager();
            }
            return instance;
        }
        public void GenerateFakeAnimals() {
            if (animals != null) {
                return;
            }
            animals = new List<Animal>() {
                new Dog() {
                    Name = "Nick",
                    Age = 3,
                    FoodType = FoodType.Carnivore
                },
                new Cat() {
                    Name = "Mimi",
                    Age = 2,
                    FoodType = FoodType.Carnivore
                },
                new People() {
                    FoodType = FoodType.Omnivore,
                    Name="nguyern van a",
                    Age = 18,                    
                },
                new People() {
                    FoodType = FoodType.Omnivore,
                    Name="nguyern van B",
                    Age = 30,
                }
            };
        }
        public void Analyze() {
            int numberOfCat = 0;
            int numberOfDog = 0;
            int numberOfPeople = 0;
            foreach (var item in animals)
            {
                if (item is Dog)
                {
                    numberOfDog++;
                }
                else if (item is Cat) {
                    numberOfCat++;
                } else if(item is People) {
                    numberOfPeople++;
                }                        
            }
        }
    }

}

