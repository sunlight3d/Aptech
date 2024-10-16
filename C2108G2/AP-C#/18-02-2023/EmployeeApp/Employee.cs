using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EmployeeApp
{
    public abstract class Employee
    {
        //field = variable
        private int empID;
        private string empName;
        private DateTime dob;
        private string department;
        private int numWork;
        //property = method
        public int EmpID { 
            get => empID; 
            set {
                if (value < 0) {
                    throw new Exception("Employee ID must be >= 0");
                }
                empID = value;
            }
        }
        public string EmpName { get => empName; 
            set {
                if (value.Length < 6 || value.Length > 40) {
                    throw new Exception("Value must be 6 => 40 characters");
                }
                empName = value;
            } 
        }
        public DateTime DOB { 
            get => dob; 
            set {
                int age = DateTime.Now.Year - dob.Year;
                if (age <= 18) {
                    throw new Exception("Age must be > 18");
                }
                dob = value;
            } 
        }
        public string  Department { get => department; set => department = value; }
        public int NumWork {
            get => numWork;
            set {
                if (numWork < 0) {
                    throw new Exception("num work must >= 0");
                }
                numWork = value;
            }
        }
        public Employee()
        {
            EmpID = 10;
            EmpName = "Nguyen Van A";
            department = "Aptech";
            NumWork = 0;
            DOB = DateTime.Parse("2000/12/31");
        }
        public Employee(int empID, string empName, DateTime dob, string department, int numWork) {
            EmpID = empID;
            EmpName = empName;
            DOB = dob;
            Department = department;
            NumWork = numWork;
        }
        public void DisplayDetail() {
            Console.WriteLine(
                $"empID : {EmpID}"+
                $"EmpName : {EmpName}" +
                $"DOB : {DOB}" +
                $"Department : {Department}" +
                $"NumWork : {NumWork}"
            );
        }
        public abstract double CalculateSalary();
        public void InputData() {
            try
            {
                Console.WriteLine("Enter emp ID: ");
                EmpID = int.Parse(Console.ReadLine() ?? "0");

                Console.WriteLine("Enter emp name: ");
                EmpName = Console.ReadLine() ?? "";

                Console.WriteLine("Enter dob(yyyy/MM/dd): ");
                DOB = DateTime.Parse(Console.ReadLine() ?? "");

                Console.WriteLine("Enter department: ");
                Department = Console.ReadLine() ?? "";

                Console.WriteLine("Enter numwork: ");
                NumWork = Convert.ToInt32(Console.ReadLine() ?? "");

            }
            catch (Exception e) {
                Console.WriteLine("Invalid input");
                InputData();
            }                         

        }
    }
}
