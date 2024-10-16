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
        
        public double CalculateBonus(string designation, int tenure, double salary)
        {
            
            if (designation.ToLower().Equals("manager"))
            {
                return tenure <= 5 ? salary * 1.5 : salary * 2;
            } else if (designation.ToLower().Equals("engineer"))
            {
                return tenure <= 5 ? salary : salary * 2;
            }
            else if (designation.ToLower().Equals("technician"))
            {
                return tenure <= 3 ? salary * 0.25 : (tenure > 3 && tenure <= 5 ? salary * 0.5 : salary * 2);
            }
            return 0;
        }
        
        /*
        public double CalculateBonus(string designation, int tenure, double salary)
            => designation.ToLower().Equals("manager") ? (tenure <= 5 ? salary * 1.5 : salary * 2)
                : ((designation.ToLower().Equals("engineer") ? tenure <= 5 ? salary : salary * 2 :
                (tenure <= 3 ? salary * 0.25 : (tenure > 3 && tenure <= 5 ? salary * 0.5 : salary * 2))));
        */
        public void DisplayDetails()
        {
            
        }
    }
}
