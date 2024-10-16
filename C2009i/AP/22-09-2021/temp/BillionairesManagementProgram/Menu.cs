using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BillionairesManagementProgram
{
    public class Menu:IMenu
    {
        public void Analyze()
        {
            
        }

        public void Find()
        {
            
        }

        public void Input()
        {
            
        }

        public void Open()
        {
            
        }

        public void Save()
        {
            
        }
        
        public void Sort()
        {
            
        }
        public void ShowMenu()
        {                        
            string choice = "";
            while (choice != "7")
            {
                Console.WriteLine("+------------------------------------------------------------------+");
                Console.WriteLine("| BILLIONAIRES PROFILE MANAGEMENT PROGRAM |");
                Console.WriteLine("+ ------------------------------------------------------------------+");
                Console.WriteLine("| 1.Input | 2.Sort | 3.Analyze | 4.Find | 5.Save | 6.Open | 7.Exit |");
                Console.WriteLine("+ ------------------------------------------------------------------+");
                Console.WriteLine("Enter your choice : ");
                choice = (Console.ReadLine() ?? "").Trim();                
                Console.WriteLine($"Your choice: {choice}");
                if (choice.Equals("1")) { 

                } else if (choice.Equals("1"))
                {

                }
                else if (choice.Equals("2"))
                {

                }
                else if (choice.Equals("3"))
                {

                }
                else if (choice.Equals("4"))
                {

                }
                else if (choice.Equals("5"))
                {

                }
                else if (choice.Equals("6"))
                {

                }
                else if (choice.Equals("7"))
                {
                    break;
                }
                Console.WriteLine("Do you want to continue ?");
                Console.WriteLine("- Yes, I do. (press ‘y’, ‘Y’)");
                Console.WriteLine("- No, I don’t. (press ‘n’, ‘N’)");
                Console.WriteLine("- Please clear the screen!(press ‘c’, ‘C’)");
                Console.WriteLine("Enter your choice : ");
                //?? = elvis(C#, js, Kotlin, Dart)
                //Console.ReadLine()?.Trim(); //(C#, js, Kotlin, Dart, Swift)
                choice = (Console.ReadLine() ?? "").Trim();
                /*
                if (choice.ToLower().Equals("n"))
                {
                    choice = "7"; 
                }
                */
                choice = choice.ToLower().Equals("n") ? "7" : choice;
                if (choice.ToLower().Equals("c"))
                {
                    Console.Clear();
                }

            }
        }
    }
}
