using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace baitap004
{
    internal class Employee
    {
        private int employeeID;
        private string employeeName;
        private DateTime dob;
        private string department;
        int numberOfWorkings;
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
            get { return employeeName; }
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
        public string Department { get; set; }
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
        void Input() {
            Console.WriteLine("Enter id: ");
            int employeeID = int.Parse(Console.ReadLine() ?? string.Empty);

            

        }
    }
}
