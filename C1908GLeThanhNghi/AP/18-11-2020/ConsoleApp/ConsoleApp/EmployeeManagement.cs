using System;
using System.Collections.Generic;
using System.Text;
using System.Linq;
using System.IO;
using CsvHelper;
using System.Globalization;

namespace ConsoleApp
{
    
    public class EmployeeManagement
    {
        private int numberOfEmployees;
        private List<Employee> employees = new List<Employee>();
        private string filePath = "output.txt";
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
            this.employees.Sort((e1, e2) =>
                ((e1.DailySalary - e2.DailySalary < 0 ? -1 :
                    ((e1.DailySalary - e2.DailySalary == 0) ? 0 : 1))));
            Console.WriteLine("Sort");
        }
        private void SaveEmployeesToFile() {
            Console.WriteLine("Enter file name : ");
            filePath = Console.ReadLine();
            using (var writer = new StreamWriter($"{filePath}.csv"))
            using (var csv = new CsvWriter(writer, CultureInfo.InvariantCulture))
            {
                csv.WriteRecords(employees);
            }
        }
        private void ReadEmployeesFromFile() {
            Console.WriteLine("Enter file name : ");
            filePath = Console.ReadLine();
            using (var reader = new StreamReader($"{filePath}.csv"))
            using (var csv = new CsvReader(reader, CultureInfo.InvariantCulture))
            {
                var records = csv.GetRecords<Employee>();
                employees.Clear();
                foreach (var record in records) {
                    employees.Add(new Employee()
                    {
                        Id = record.Id,
                        Name = record.Name,
                        DailySalary= record.DailySalary,
                        WorkingDays = record.WorkingDays
                    });
                }
                Console.WriteLine("dddh");
            }
        }
        private void Analyze()
        {
            /*
             * There are X employees with Y working days
             * mapStatistic[5] = 10;
             * key : working days
             * values : number of Employees
             * mapStatistic[5] = 2;
             * mapStatistic[7] = 2;
             * mapStatistic[3] = 1;
             */
            Dictionary<int, int> mapStatistic = new Dictionary<int, int>();
            foreach (Employee employee in this.employees) {
                if (!mapStatistic.ContainsKey(employee.WorkingDays)) {
                    mapStatistic.Add(employee.WorkingDays, 0);
                }
                mapStatistic[employee.WorkingDays] =
                    mapStatistic[employee.WorkingDays] + 1;

            }
            foreach (KeyValuePair<int, int> entry in mapStatistic)
            {
                Console.WriteLine($"There are {entry.Value} " +
                    $"employees with working days: {entry.Key}");
            }
            
        }
        private void GenerateFakeData() {
            employees = new List<Employee>()
            {
                new Employee() {
                    Id = 1,
                    Name = "aa",                    
                    WorkingDays = 4,
                    DailySalary = 123
                },
                new Employee() {
                    Id = 2,
                    Name = "aa",
                    WorkingDays = 8,
                    DailySalary = 111
                },
                new Employee() {
                    Id = 3,
                    Name = "bb",
                    WorkingDays = 4,
                    DailySalary = 333
                },
                new Employee() {
                    Id = 4,
                    Name = "cc",
                    WorkingDays = 6,
                    DailySalary = 888
                },
                new Employee() {
                    Id = 5,
                    Name = "dd",
                    WorkingDays = 8,
                    DailySalary = 112
                }

            };
        }
        private void Find()
        {
            //Find employee with max salary
            float maxSalary = this.employees
                    .Max(employee => employee.DailySalary);
            List<Employee> foundEmployees = this.employees
                    .Where(employee => employee.DailySalary == maxSalary).ToList();
            Console.WriteLine("Find");
        }
        private void Save()
        {
            SaveEmployeesToFile();
            Console.WriteLine("Save");
        }
        private void Open()
        {
            ReadEmployeesFromFile();
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
                GenerateFakeData();
                switch (choice) {
                    case "1":
                        Input();
                        showEmployees();
                        break;
                    case "2":
                        Sort();
                        showEmployees();
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
