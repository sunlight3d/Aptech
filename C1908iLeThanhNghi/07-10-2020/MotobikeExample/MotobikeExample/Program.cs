using MotobikeExample.Model;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;

namespace MotobikeExample
{
    class Program
    {
        static void Main(string[] args)
        {
            List<Motobike> motobikes = new List<Motobike>() { 
                new Motobike() { 
                    Name = "b",
                    Manufacture = "bb",
                    Price = 1111,
                    ReleaseYear = 1991
                },
                new Motobike() {
                    Name = "a",
                    Manufacture = "aa",
                    Price = 2222,
                    ReleaseYear = 1992
                },
                new Motobike() {
                    Name = "c",
                    Manufacture = "bb",
                    Price = 3333,
                    ReleaseYear = 1993
                },
            };
            
            CreateMenu();
            string choice = "y";
            while (choice != "7" || choice.ToUpper() != "N") {
                Console.WriteLine("Enter your choice: ");
                choice = Console.ReadLine();
                if (choice == "7") {
                    break;
                }
                switch (choice) {
                    case "1":
                        Motobike.Input(motobikes);
                        break;
                    case "2":
                        motobikes = motobikes.OrderBy(motobike => motobike.Name).ToList();
                        Motobike.Display(motobikes);
                        break;
                    case "3":
                        var groupedList = motobikes
                            .GroupBy(motobike => motobike.Manufacture)
                            .Select(groupedList => groupedList.ToList())
                            .ToList();
                        groupedList.ForEach(item =>
                        {
                            int numberOfMotobike = item.Count;
                            string manufacture = item[0].Manufacture;
                            Console.WriteLine($"There are {numberOfMotobike} manufactures from '{manufacture}'");
                        });
                        
                        break;
                    case "4":                        
                        Motobike.find(motobikes);
                        break;
                    case "5":
                        Motobike.SaveToCsvFile(motobikes);
                        break;
                    case "6":
                        motobikes = Motobike.ReadDataFromCsv();
                        break;                    
                }
                Console.WriteLine("Do you want to continue ?: ");
                choice = Console.ReadLine();
                if (choice.ToUpper() != "Y") {
                    break;
                }
            }
        }
        static void CreateMenu() {
            Console.WriteLine("-----------------------------------------------");
            Console.WriteLine("      MOTOBIKE STORE MANAGEMENT PROGRAM        ");
            Console.WriteLine("-----------------------------------------------");
            Console.WriteLine("|1. Input |2. Sort |3. Analyze |4. Find |5. Save |6. Open |7. Exit |");

        }
    }
}
