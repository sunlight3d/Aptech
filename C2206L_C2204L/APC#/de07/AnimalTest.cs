using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace de07
{
    class AnimalTest
    {
        public void showMenu() {
            int choice = 0;
            CatManagement catManagement = new CatManagement();
            do
            {
                Console.WriteLine("1. Input Cat information:");
                Console.WriteLine("2. Display all Cat from list");
                Console.WriteLine("3. Find Cat by index");
                Console.WriteLine("4. Exit program");
                Console.Write("Enter your choice: ");
                choice = int.Parse(Console.ReadLine());
                if (choice == 1)
                {
                    catManagement.Input();
                }
                else if (choice == 2)
                {
                    catManagement.Display();
                }
                else if (choice == 3)
                {
                    try
                    {
                        Console.WriteLine("enter index = ");
                        int index = int.Parse(Console.ReadLine() ?? "0");
                        Console.WriteLine($"Cat is {catManagement[index]}");
                    }
                    catch (ArgumentOutOfRangeException ex) {
                        Console.WriteLine("error: " + ex.Message);
                    }
                    
                }
                else if (choice == 4)
                {
                    break;
                }
                else {
                    Console.WriteLine("Please choose 1-4");
                }

            } while (choice != 4);
        }
    }
}
