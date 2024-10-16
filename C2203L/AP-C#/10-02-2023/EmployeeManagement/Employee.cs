using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Security.Cryptography.X509Certificates;
using System.Text;
using System.Threading.Tasks;

namespace EmployeeManagement
{
    public abstract class Employee
    {
        //fields = variables
        private int empID;
        private string empName;
        private DateTime dob;
        private string department;
        private int numWork;
        //properties = functions
        public int EmpID { 
            get => empID;
            set {
                if (value < 0) {
                    throw new Exception("Employee'ID cannot be < 0");
                }
                empID = value;
            }
        }
        public string EmpName { 
            get => empName;
            set { 
                if(value.Length < 6 || value.Length > 40 || string.IsNullOrEmpty(value)) {
                    throw new Exception("Length must be 6=>40 characters");
                }
                empName = value;
            }
        }
        private int CalculateAge(DateTime birthDate)
        {
            int age = 0;
            age = DateTime.Now.Year - birthDate.Year;
            if (DateTime.Now.DayOfYear < birthDate.DayOfYear) {
                age = age - 1;
            }
                            
            return age;
        }
        public DateTime DOB { 
            get => dob;
            set {
                if (CalculateAge(value) < 18) {
                    throw new Exception("Age must be >= 18");
                }
                dob = value;
            }
        }
        public int NumWork { 
            get => numWork;
            set { 
                if (value < 0)
                {
                    throw new Exception("numwork must be >= 0");
                }
                numWork = value;
            }
        }
        public string Department { 
            get => department; 
            set => department = value; 
        }
        public Employee() {
            empID = 10;
            department = "Aptech";
            numWork = 0;
        }
        public Employee(int empID, string empName,DateTime dob, string department, int numWork) {
            EmpID = empID;
            EmpName = empName;
            DOB = dob;
            Department = department;
            NumWork = numWork;
        }
        public virtual void Input() {
            Console.WriteLine("Enter the empID: ");
            EmpID = Convert.ToInt32(Console.ReadLine());

            Console.WriteLine("Enter the empName: ");
            EmpName = Console.ReadLine() ?? "";

            Console.WriteLine("Enter your date of birth (YYYY-MM-DD): ");
            DOB = Convert.ToDateTime(Console.ReadLine() ?? "");

            Console.WriteLine("Enter the department: ");
            Department = Console.ReadLine() ?? "";
        }
        public virtual void DisplayDetail() {
            Console.WriteLine(this.ToString());
        }
        public override string ToString()
                => $"empID: {EmpID}" +
                        $"EmpName: {EmpName}" +
                        $"dob: {DOB}" +
                        $"Department: {Department}" +
                        $"NumWork: {NumWork}";
        public abstract double CalculateSalary();
    }
}
