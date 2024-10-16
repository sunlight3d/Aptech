using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exam4
{
    public interface IEmployee
    {
        public double CalculateBonus(string designation, int tenure, double salary);
        public void DisplayDetails();

    }
}
