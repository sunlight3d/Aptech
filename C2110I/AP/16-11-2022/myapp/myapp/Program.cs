using System.Diagnostics;
using System.Numerics;
using myapp.models;

namespace myapp {
    public class Program
    {
        public static void Main(String[] args)
        {                        
            int choice = 0;
            StudentManagement studentManagement = new StudentManagement();
            while (choice != 7) {
                Console.WriteLine("+------------------------------------------------------------------+");
                Console.WriteLine("| STUDENT EXAM RESULT MANAGEMENT PROGRAM |");
                Console.WriteLine("+------------------------------------------------------------------+");
                Console.WriteLine("| 1.Input | 2.Sort | 3.Analyze | 4.Find | 5.Save | 6.Open | 7.Exit |");
                Console.WriteLine("+------------------------------------------------------------------+");
                Console.WriteLine("Enter your choice(1-7) : ");
                choice = Convert.ToInt32(Console.ReadLine());
                switch (choice) {
                    case 1:
                        //Console.WriteLine("You choose 1 ");
                        studentManagement.Input();
                        
                        break;
                    case 2:
                        //Console.WriteLine("You choose 2 ");
                        studentManagement.Sort();
                        break;
                    case 3:
                        //Console.WriteLine("You choose 3 ");
                        studentManagement.Analyze();
                        break;
                    case 4:
                        Console.WriteLine("You choose 4 ");
                        break;
                    case 5:
                        Console.WriteLine("You choose 5 ");
                        break;
                    case 6:
                        Console.WriteLine("You choose 6 ");
                        break;
                    case 7:
                        break;
                    default:
                        Console.WriteLine("Please choose(1-7)");
                        break;
                }
                if(choice == 7)
                {
                    break;
                }
                studentManagement.Display();
                Console.WriteLine("Do you want to continue ?");
                Console.WriteLine("-Yes, I do. (press ‘y’, ‘Y’)");
                Console.WriteLine("- No, I don’t. (press ‘n’, ‘N’)");
                Console.WriteLine("- Please clear the screen!(press ‘c’, ‘C’)");
                Console.WriteLine("Your choice:");
                //string? continueOrNot = Console.ReadLine();//string? => "optional string" => "nullable string"
                //string continueOrNot = (Console.ReadLine() == null) ? "" : Console.ReadLine();
                string continueOrNot = Console.ReadLine() ?? "";//default value                
                if (continueOrNot.Trim().ToLower().Equals("n"))
                {
                    break;
                }
                else if (continueOrNot.Trim().ToLower().Equals("c")) {
                    Console.Clear();
                }
            }
            Console.WriteLine("Program ended");
            
        }
    }
}


