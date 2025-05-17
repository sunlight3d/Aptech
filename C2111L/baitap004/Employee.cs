using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Net.Mime.MediaTypeNames;

namespace baitap004
{
    public abstract class Employee
    {
        private int employeeID;
        private string? employeeName;
        private DateTime dob;
        private string? department;
        int numberOfWorkings;
        public abstract int CalculateSalary();
        public virtual void DisplayDetail() {
            Console.WriteLine($"Id: {EmployeeID},\n" +
                $"name: {EmployeeName},\n" +
                $"dob: {DOB}, \n" +
                $"department: {Department},\n" +
                $"numberOfWorkings : {NumberOfWorkings}\n");
        }


        public int EmployeeID { 
            get { return employeeID; }
            set {
                if (value < 0) { 
                    throw new ArgumentOutOfRangeException("Employee's ID must be >= 0");
                }
                employeeID = value; 
            }
        }
        public string EmployeeName { 
            get { return employeeName ?? ""; }
            set {
                if (value.Length < 6 || value.Length > 40) {
                    throw new ArgumentOutOfRangeException("Length of employee must be from 6-40 characters");
                }
                employeeName = value;
            }
        }
        public DateTime DOB { 
            get { return dob; }
            set {
                // Save today's date.
                var today = DateTime.Today;

                // Calculate the age.
                var age = today.Year - value.Year;

                // If the birthdate hasn't arrived yet, subtract one year.
                if (age <= 18) {
                    throw new Exception("Age must be greater than 18");
                }
                dob = value;
            }
        }
        public string Department { get => department; set => department = value; }
        public int NumberOfWorkings {
            get => numberOfWorkings; 
            set {
                if (value < 0) {
                    throw new ArgumentOutOfRangeException("Numwork > 0");
                }
                numberOfWorkings = value;
            }
        }
        public Employee() {
            EmployeeID = 10;
            EmployeeName = string.Empty;
            Department = "Aptech";
            NumberOfWorkings = 0;
        }
        public Employee(int _employeeID, string _employeeName, DateTime _dob, string _department, int _numberOfWorking)  
        {
            EmployeeID = _employeeID;
            EmployeeName = _employeeName;
            DOB = _dob;
            Department = _department;
            NumberOfWorkings = _numberOfWorking;
        }
        public virtual void Input() {
            Console.WriteLine("Enter id: ");
            this.EmployeeID = int.Parse(Console.ReadLine() ?? string.Empty);

            Console.WriteLine("Enter name: ");
            this.EmployeeName = Console.ReadLine() ?? string.Empty;

            Console.WriteLine("Enter dob(eg: 25/12/1999): ");
            string stringDOB = Console.ReadLine() ?? string.Empty;
            string[] dobs = stringDOB.Split("/");
            this.DOB = new DateTime(int.Parse(dobs[2]), int.Parse(dobs[1]), int.Parse(dobs[0]),0,0,0);

            Console.WriteLine("Enter department: ");
            this.Department = Console.ReadLine() ?? string.Empty;

            Console.WriteLine("Years of workings: ");
            this.NumberOfWorkings = int.Parse(Console.ReadLine() ?? "0");


        }
    }
}
