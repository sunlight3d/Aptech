using System.Collections.Generic;
using System;

namespace De07
{
    internal class AnimalTest
    {
        static void Main(string[] args)
        {
            
            int choice = 0;
            CatManagement catManagement = new CatManagement();
            while (choice != 4) {
                Console.WriteLine("1.Input Cat information:");
                Console.WriteLine("2.Display all Cat from list");
                Console.WriteLine("3.Find Cat by index");
                Console.WriteLine("4.Exit program");
                Console.WriteLine("Enter your choice: ");
                choice = Convert.ToInt16(Console.ReadLine());
                switch (choice) { 
                    case 1:
                        catManagement.InputCats();
                        break;
                    case 2:
                        catManagement.Display();
                        break;
                    case 3:
                        Console.WriteLine("Enter index: ");
                        int index = Convert.ToInt16(Console.ReadLine());
                        catManagement[index].DisplayData();
                        break;
                    case 4:
                        break;
                    default:
                        Console.WriteLine("You must enter 1-4");
                        break;
                }
            }
        }
    }
}