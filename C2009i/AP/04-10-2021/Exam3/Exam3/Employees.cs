using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exam3
{
    public abstract class Employees
    {
        //fields
        private int empID;
        private string empName;
        private DateTime dob;//Date Of Birth
        private string department;
        private int numWork;//number of experienced years
        //properties (functions/methods)
        public int EmpID { 
            get => empID; 
            set {
                if (value < 0)
                {
                    throw new Exception("Employee's id must be >=0");
                }
                empID = value;
            } 
        }

        public string EmpName { 
            get => empName;
            set { 
                if(value.Length < 6 || value.Length > 40)
                {
                    throw new Exception("Employee'name must be 6-40 in length");
                }
                empName = value;
            } 
        }        
        public DateTime DOB
        {
            get => dob;
            set
            {
                int age = DateTime.Now.Year - value.Year;
                if (age <= 18)
                {
                    throw new Exception("Age must be >= 18");
                }
                dob = value;
            }
        }
        public string Department { get => department; set => department = value ?? ""; }
        public int NumWork
        {
            get => numWork;
            set
            {
                if (numWork < 0)
                {
                    throw new Exception("numwork must be >= 0");
                }
                numWork = value;
            }
        }
        public Employees()
        {
            empID = 0;
            empName = "Nguyen Van A";
            department = "Aptech";
            numWork = 0;
            dob = new DateTime(1997, 12, 30);
        }
        public Employees(
            int employeeID,
            string employeeName, 
            DateTime dob, 
            string department, 
            int numWork)
        {
            empID = employeeID;
            empName = employeeName;
            this.dob = dob;
            this.department = department;
            this.numWork = numWork;            
        }
        private DateTime convertStringToDateTime(string stringDateTime)
        {
            //Example: stringDateTime => 25/12/1993
            try
            {
                string[] arrayOfStrings = stringDateTime.Split("/");
                if (arrayOfStrings.Length != 3)
                {
                    throw new Exception("Invalid date/time format");
                }
                int day = Convert.ToInt32(arrayOfStrings[0]);
                int month = Convert.ToInt32(arrayOfStrings[1]);
                int year = Convert.ToInt32(arrayOfStrings[2]);
                return new DateTime(year, month, day);
            }
            catch (Exception e)
            { 
                throw new Exception($"cannot convert to datetime: {e.Message}");
            }
        }
        public virtual void Input()
        {
            try {
                Console.WriteLine("Input employeeID: ");
                EmpID = Convert.ToInt32(Console.ReadLine());

                Console.WriteLine("Input employeeName: ");
                EmpName = Console.ReadLine();

                Console.WriteLine("Input dob(dd/mm/yyyy): ");
                DOB = this.convertStringToDateTime(Console.ReadLine());

                Console.WriteLine("Input department: ");
                Department = Console.ReadLine();

                Console.WriteLine("Input numWork: ");
                NumWork = Convert.ToInt32(Console.ReadLine());

            } catch(Exception error)
            {
                Console.WriteLine($"Cannot input information. Error: {error.Message}");
            }
        }
        public virtual void DisplayDetail()
        {            
            Console.WriteLine("=============================================");
            Console.WriteLine($"EmpID: {EmpID}");
            Console.WriteLine($"EmpName: {EmpName}");
            Console.WriteLine($"DOB: {DOB}");
            Console.WriteLine($"Department: {Department}");
            Console.WriteLine($"Number of work: {EmpName}");            
        }
        public abstract double CalculateSalary();        
    }
}
