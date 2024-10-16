using Microsoft.VisualBasic.CompilerServices;
using System;
using System.Collections.Generic;
using System.Text;

namespace MotobikeExample.Model
{
    public class Motobike
    {
        //Encapsulation
        public String Name { get; set; } //properties = attributes + getter + setter 
        public String Manufacture { get; set; }
        public int ReleaseYear { get; set; }
        public double Price { get; set; }
        public static void Display(List<Motobike> motobikes) {
            motobikes.ForEach(motobike =>
            {
                Console.Write($"| {motobike.Name,5:G} | ");
                Console.Write($"{motobike.Manufacture,5:G} | ");
                Console.Write($"{motobike.ReleaseYear,10:N} | ");
                Console.Write($"{motobike.Price,10:N} | ");
                Console.WriteLine();
            });
        }
        //Ham khoi tao        
        public static void Input(List<Motobike> motobikes) {
            Console.WriteLine("Enter number of motobikes:");
            int numberOfMotobike = Convert.ToInt32(Console.ReadLine());
            int i = 0;
            do
            {
                Console.WriteLine("Car number: {0}", i + 1);
                Console.WriteLine("Enter name: ");
                string name = Console.ReadLine();

                Console.WriteLine("Enter Manufature: ");
                string manufacture = Console.ReadLine();

                int releaseYear = 0;
                while (releaseYear < 1990)
                {
                    Console.WriteLine("Enter release year: ");
                    releaseYear = Convert.ToInt32(Console.ReadLine());
                    if (releaseYear < 1990) {
                        Console.WriteLine("Motorbike release year must be greater than or equal to 1990.");
                    }
                    
                }                
                double price = 0.0; 
                while (price < 500 || price > 5000)
                {
                    Console.WriteLine("Enter price: ");
                    price = Convert.ToInt32(Console.ReadLine());
                    if (price < 500 || price > 5000) {
                        Console.WriteLine("Motorbike price must be between 500($) and 5000($).");
                    }                    
                }
                motobikes.Add(new Motobike()
                {
                    Name = name,
                    Manufacture = manufacture,
                    ReleaseYear = releaseYear,
                    Price = price
                });
                i = i + 1;
            } while (i < numberOfMotobike);            
        }
    }

}
