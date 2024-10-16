using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace De03
{
    internal class Employee : IEmployee

    {
        private string _empName;
        private int _yearsOfService;
        protected double _bonus;

        public string designation;
        public double salary;

        public string EmpName {
            get => _empName;
            set {
                if (value.Length >= 6 && value.Length <= 40)
                {
                    _empName = value;
                }
                else {
                    throw new Exception("Name must be 6 to 40 characters");
                }

            }
        }
        public int YearsOfService { 
            get => _yearsOfService;
            set {
                if (value >= 0 && value <= 60)
                {
                    _yearsOfService = value;
                }
                else {
                    throw new Exception("Value must be 0->60");
                }
            }
        }

        public virtual double CalculateBonus(string designation, int tenure, double salary)
        {
            this.designation = designation;
           
            if (designation.Trim().ToLower().Equals("engineer")) {
                /*
                if (tenure <= 5) {
                    bonus = salary * 1.5;
                } else {
                    bonus = salary * 2;
                }
                */
                _bonus = tenure <= 5 ? salary * 1.5 : salary * 2;
            } else if (designation.Trim().ToLower().Equals("technician ")) {
                /*
                if (tenure <= 3) {
                    bonus = salary * 0.25;
                } else if (tenure > 3 && tenure <= 5) {
                    bonus = salary * 0.5;
                } else {
                    bonus = salary * 2;
                } 
                */
                _bonus = tenure <= 3 ? salary * 0.25 :
                    (tenure > 3 && tenure <= 5 ? salary * 0.5 : salary * 2);
            }
            return _bonus;
        }
        //virtual = overridable
        public virtual void DisplayDetails()
        {
            //CalculateBonus(designation, YearsOfService, salary);//not good
            Console.WriteLine(
                "Employee's name: " + _empName +
                "year of service: " + _yearsOfService +
                "bonus: " + _bonus +
                "designation: " + designation +
                "salary: " + salary
                );
        }
    }
}
