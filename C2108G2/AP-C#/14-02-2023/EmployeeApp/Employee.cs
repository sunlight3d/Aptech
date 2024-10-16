using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EmployeeApp
{
    internal class Employee : IEmployee
    {
        private string _empName;
        private int _yearsOfService;
        protected double _bonus;

        public string designation;
        public double salary;

        //properties = getter / setter
        public string EmpName
        {
            get => _empName;
            set {
                if (value.Length < 6 || value.Length > 40)
                {
                    throw new Exception("Emp name must be 6-40 characters");
                }
                _empName = value;
            }
        
        }
        public int YearsOfService
        {
            get => _yearsOfService;
            set
            {
                if (value < 0 || value > 60)
                {
                    throw new Exception("_yearsOfService must be 0->60 ");
                }
                _yearsOfService = value;
            }

        }
        
        public virtual double CalculateBonus(string designation, int tenure, double salary)
        {
            if (designation.ToLower().Trim().Equals("manager"))
            {
                /*
                if (tenure < 5)
                {
                    _bonus = salary * 1.5;
                }
                else {
                    _bonus = salary * 2;
                }
                */
                _bonus = salary * (tenure < 5 ? 1.5 : 2);
            }
            else if (designation.ToLower().Trim().Equals("engineer")) //" Engineer    "
            {
                _bonus = salary * (tenure < 5 ? 1 : 2);
            }
            else if (designation.ToLower().Trim().Equals("technician")) 
            {
                _bonus = salary * (tenure <= 3 ? 0.25 
                            : (tenure > 3 && tenure <= 5 ? 0.5 : 2));
            }
            return _bonus;
        }
        /*
        not recommended !
        public double CalculateBonus2(string designation, int tenure, double salary)
            => designation.ToLower().Trim().Equals("manager") ?
                    salary * tenure < 5 ? 1.5 : 2 :
                    (designation.ToLower().Trim().Equals("engineer") ? salary * tenure < 5 ? 1 : 2 : (
                        designation.ToLower().Trim().Equals("technician") ? salary * tenure <= 3 ? 0.25
                                : (tenure > 3 && tenure <= 5 ? 0.5 : 2) : 0
                    ));
            
        */
        public void DisplayDetails()
        {
            throw new NotImplementedException();
        }
    }
}
