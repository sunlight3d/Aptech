using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp
{
    
    public class EmployeeManagement
    {
        private int numberOfEmployees;
        private List<Employee> employees = new List<Employee>();
        private void Input() {
            Console.WriteLine("Number of employees: ");
            numberOfEmployees = Convert.ToInt32(Console.ReadLine());
            for (int i = 0; i < numberOfEmployees; i++) {
                Employee newEmployee = Employee.InputEmployee();//factory method
                employees.Add(newEmployee);
            }
        }
        private void showEmployees() { 
            foreach(Employee eachEmployee in employees)
            {
                Console.WriteLine(eachEmployee.ToString());
            }
        }
        private void Sort()
        {
            Console.WriteLine("Sort");
        }
        private void Analyze()
        {
            Console.WriteLine("Analyze");
        }
        private void Find()
        {
            Console.WriteLine("Find");
        }
        private void Save()
        {
            Console.WriteLine("Save");
        }
        private void Open()
        {
            Console.WriteLine("Open");
        }
        private bool IsValidChoice(string choice) =>
            new List<string>()
            {
                "1", "2", "3", "4", "5", "6", "7", "y", "n", "c"
            }.Contains(choice.Trim().ToLower());
            
        
        public void CreateMenu()
        {            
            string choice;
            do
            {
                Console.WriteLine("+------------------------------------------------------------------+");
                Console.WriteLine("|                    EMPLOYEE MANAGEMENT PROGRAM                   |");
                Console.WriteLine("+ -----------------------------------------------------------------+");
                Console.WriteLine("| 1.Input | 2.Sort | 3.Analyze | 4.Find | 5.Save | 6.Open | 7.Exit |");
                Console.WriteLine("+ ------------------------------------------------------------------+");
                Console.WriteLine("Enter your choice: ");
                choice = Console.ReadLine();
                switch (choice) {
                    case "1":
                        Input();
                        showEmployees();
                        break;
                    case "2":
                        Sort();
                        break;
                    case "3":
                        Analyze();
                        break;
                    case "4":
                        Find();
                        break;
                    case "5":
                        Save();
                        break;
                    case "6":
                        Open();
                        break;
                    default:
                        break;
                }
                if (choice != "7")
                    {
                        do
                        {
                            Console.WriteLine("Do you want to continue(y, n) ?");
                            Console.WriteLine("Clear screen(c, C)");
                            choice = Console.ReadLine().Trim();
                            if (choice.ToLower().Equals("n"))
                            {
                                //break;
                                Environment.Exit(0);
                            }
                            if (choice.ToLower().Equals("c"))
                            {
                                Console.Clear();
                            }
                        } while (!this.IsValidChoice(choice));                        
                    }
                } while (choice != "7") ;
                Console.WriteLine("Program ended.");
            }
    }
}
