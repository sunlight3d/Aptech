using System;
using System.Collections;

namespace ConsoleApp
{
    class Program
    {
        static void Main(string[] args)
        {
            CreateMenu();
        }
        private static void CreateMenu(){
            int choice = -1 ;
            
            ContactManager contactManager = new ContactManager();
            while (choice != 4) {
                Console.WriteLine("Enter 1 to 4");
                choice = Convert.ToInt32(Console.ReadLine());
                switch (choice) {
                    case 1:
                        Console.WriteLine("1. Add new contact");
                        contactManager.AddNewContact();
                        break;
                    case 2:
                        Console.WriteLine("2. Find a contact by name");
                        contactManager.FindAContactByName();
                        break;
                    case 3:
                        Console.WriteLine("3. Display contacts");
                        contactManager.DisPlayAll();
                        break;
                    default:
                        break;
                }
            }

        }
    }
}
