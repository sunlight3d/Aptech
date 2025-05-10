using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace de03
{
    internal class NewEmployee:Employee
    {
        public override double CalculateBonus(string designation, int tenure, double salary)
        {
            if (designation.ToLower().Trim().Equals("teacher")) { 
                _bonus = salary * (tenure <= 3 ? 3 : 4);
            } else
            {
                _bonus = base.CalculateBonus(designation, tenure, salary);
            }
            return _bonus;
        }
        public override void DisplayDetails()
        {
            base.DisplayDetails();            
        }
    }
}
