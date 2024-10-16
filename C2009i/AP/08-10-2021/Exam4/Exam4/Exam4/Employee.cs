using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exam4
{
    public class Employee : IEmployee
    {
        private string _empName;
        private int _yearsOfService;
        protected double _bonus;
        public string Designation { get; set; }
        public Double Salary { get; set; }

        public string EmpName { get => _empName; 
            set { 
                if(value.Length < 6 || value.Length > 40)
                {
                    throw new Exception("EmpName must be 6 to 40 in Length");
                }
                _empName = value;
            } 
        }
        public int YearsOfService { get => _yearsOfService; 
            set
            {
                if (value < 0 || value > 60)
                {
                    throw new Exception("YearsOfService must be 0 - 60");
                }
                _yearsOfService = value;
            }
        }
        
        public virtual double CalculateBonus(string designation, int tenure, double salary)
        {
            
            if (designation.ToLower().Equals("manager"))
            {
                _bonus = tenure <= 5 ? salary * 1.5 : salary * 2;
            } else if (designation.ToLower().Equals("engineer"))
            {
                _bonus = tenure <= 5 ? salary : salary * 2;
            }
            else if (designation.ToLower().Equals("technician"))
            {
                _bonus = tenure <= 3 ? salary * 0.25 : (tenure > 3 && tenure <= 5 ? salary * 0.5 : salary * 2);
            }
            return _bonus;
        }
        
        /*
        public double CalculateBonus(string designation, int tenure, double salary)
            => designation.ToLower().Equals("manager") ? (tenure <= 5 ? salary * 1.5 : salary * 2)
                : ((designation.ToLower().Equals("engineer") ? tenure <= 5 ? salary : salary * 2 :
                (tenure <= 3 ? salary * 0.25 : (tenure > 3 && tenure <= 5 ? salary * 0.5 : salary * 2))));
        */
        public virtual void DisplayDetails()
        {
            Console.WriteLine($"Employee Name: {EmpName}");
            Console.WriteLine($"Designation: {Designation}");
            Console.WriteLine($"Salary: {Salary} $");
            Console.WriteLine($"Bonus: {CalculateBonus(Designation, 0, Salary)}");
            Console.WriteLine($"Total income earned: {Salary+_bonus}");            
        }
    }
}
