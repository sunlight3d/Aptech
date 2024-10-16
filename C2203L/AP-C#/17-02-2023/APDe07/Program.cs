using System;

namespace APDe07
{
    internal class Program
    {
        static int evenNumber;
        static int oddNumber;
        static void Main(string[] args)
        {
                        
            int choice = 0;
            CatManagement catManagement = new CatManagement();
            while (choice != 4)
            {
                Console.WriteLine("Please select an option:");
                Console.WriteLine("1. Input Cat information");
                Console.WriteLine("2. Display all Cat from list");
                Console.WriteLine("3. Find Cat by index");
                Console.WriteLine("4. Exit program");

                try
                {
                    choice = Convert.ToInt32(Console.ReadLine());
                }
                catch (Exception)
                {
                    Console.WriteLine("Invalid input. Please enter a number between 1 and 4.");
                    continue;
                }

                switch (choice)
                {
                    case 1:                        
                        Console.WriteLine("You selected: Input Cat information");
                        string answer = "yes";
                        while (answer.ToLower().Trim().Equals("yes")) { 
                            Cat cat = new Cat();
                            cat.InputData();
                            catManagement.AddToList(cat);
                            Console.WriteLine("Do you want to continue(yes,no) ?");
                            answer = Console.ReadLine() ?? "no";
                        }
                        break;
                    case 2:                        
                        Console.WriteLine("You selected: Display all Cat from list");
                        catManagement.Dislay();
                        break;
                    case 3:
                        // Code to find cat by index
                        Console.WriteLine("You selected: Find Cat by index");
                        int index = int.Parse(Console.ReadLine());
                        Cat selectedCat = catManagement[index];
                        selectedCat.Display();
                        break;
                    case 4:
                        Console.WriteLine("Exiting program...");
                        break;
                    default:
                        Console.WriteLine("Invalid choice. Please enter a number between 1 and 4.");
                        break;
                }
            }
            /*
            Thread t1 = new Thread(delegate ()
            {
                Thread.Sleep(1000);
                Random random = new Random();                
                while (true)
                {
                    int number = random.Next(1, 100);
                    oddNumber = number % 2 == 1 ? number : 0;
                    if (oddNumber > 0) {
                        Console.WriteLine("Random odd number: " + oddNumber);
                    }
                    
                }
            });
            Thread t2 = new Thread(delegate ()
            {
                Thread.Sleep(1000);
                Random random = new Random();
                while (true)
                {
                    int number = random.Next(1, 100);
                    evenNumber = number % 2 == 0 ? number : 0;
                    if (evenNumber > 0) {
                        Console.WriteLine("Random even number: " + evenNumber);
                    }
                    
                }
            });

            t1.Start();
            t2.Start();
            return;
            */
        }
    }
}