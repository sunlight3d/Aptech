using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace de03
{
    internal class Employee : IEmployee
    {
        private string _employeeName;
        private int _yearsOfService;
        protected double _bonus;
        public string designation;
        public double salary;
        //properties = method = function
        public string EmployeeName { 
            //R/W
            get {
                
                return _employeeName; 
            } 
            set {
                if (value.Length < 6 || value.Length > 40)
                {
                    throw new ArgumentException("Name must be between 6 to 40");
                }
                _employeeName = value; 
            }
        }
        public int YearOfService { 
            get => _yearsOfService;
            set => _yearsOfService = value;
        }


        public virtual double CalculateBonus(string designation, int tenure, double salary)
        {
            /*
            if (tenure <= 5)
            {
                _bonus = salary * 1.5;
            }
            else { 
                _bonus = salary * 2;
            }
            */

            if (designation.ToLower().Trim().Equals("manager"))
            {
                _bonus = salary * (tenure <= 5 ? 1.5 : 2);
            }
            else if (designation.ToLower().Trim().Equals("engineer"))
            {
                _bonus = salary * (tenure <= 5 ? 1 : 2);
            }
            else if (designation.ToLower().Trim().Equals("technician ")) {
                _bonus = salary * (tenure <= 3 ? 0.25 : (tenure > 3 && tenure <= 5) ? 0.5 : 2);
            }
            else
            {
                _bonus = 0;
            }

            return _bonus;
        }

        public virtual void DisplayDetails()
        {
            Console.WriteLine($"Employee Name : {_employeeName}, " +
                $"Designation: {designation}, " +
                $"Salary: {salary}, " +
                $"Bonus: {CalculateBonus(designation, _yearsOfService, salary)}, " +
                //$"Year of service: {_yearsOfService}, " +
                $"Toltal income earned: {salary + CalculateBonus(designation, _yearsOfService, salary)}");
        }
    }
}
