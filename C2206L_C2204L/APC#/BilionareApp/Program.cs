using static System.Runtime.InteropServices.JavaScript.JSType;

namespace BilionareApp
{
    internal class Program
    {
        static void Main(string[] args)
        {                        
            int choice = 0;
            while (choice != 7)
            {
                Console.WriteLine("+------------------------------------------------------------------+");
                Console.WriteLine("| BILLIONAIRES PROFILE MANAGEMENT PROGRAM                            |");
                Console.WriteLine("+ ------------------------------------------------------------------+");
                Console.WriteLine("| 1.Input | 2.Sort | 3.Analyze | 4.Find | 5.Save | 6.Open | 7.Exit |");
                Console.WriteLine("+ ------------------------------------------------------------------+");
                Console.WriteLine("Enter your choice: "); 
                choice = Convert.ToInt32(Console.ReadLine());
                switch (choice) {
                    case 1:
                        Console.WriteLine("You choose 1");
                        break;
                    case 2:
                        Console.WriteLine("You choose 2");
                        break;
                    case 3:
                        Console.WriteLine("You choose 3");
                        break;
                    case 4:
                        Console.WriteLine("You choose 4");
                        break;
                    case 5:
                        Console.WriteLine("You choose 5");
                        break;
                    case 6:
                        Console.WriteLine("You choose 6");
                        break;                        
                }
                if (choice != 7)
                {
                    Console.WriteLine("Do you want to continue(y, n, c) ?");
                    string yourDecision = Console.ReadLine() ?? "";//default value
                    if (yourDecision.ToLower().Trim().Equals("y"))
                    {

                    }
                    else if (yourDecision.ToLower().Trim().Equals("n"))
                    {
                        break;
                    }
                    else if (yourDecision.ToLower().Trim().Equals("c"))
                    {
                        // Clear the console screen
                        Console.Clear();
                    }
                    else
                    {
                        Console.WriteLine("Invalid choice, please choose: Y, y, N, n, c, C");
                    }
                }
            }
        }
    }
}