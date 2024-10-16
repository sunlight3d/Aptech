using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace De03
{
    internal class NewEmployee:Employee
    {
        public override double CalculateBonus(string designation, int tenure, double salary)
        {
            if (designation.Trim().ToLower().Equals("teacher"))
            {
                _bonus = tenure <= 3 ? salary * 3 : salary * 4;
                return _bonus;
            }
            else {
                return base.CalculateBonus(designation, tenure, salary);
            }
        }
        public override void DisplayDetails()
        {
            base.DisplayDetails();
        }
    }
}
