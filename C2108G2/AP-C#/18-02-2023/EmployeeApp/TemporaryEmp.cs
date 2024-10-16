using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EmployeeApp
{
    public class TemporaryEmp : Employee
    {
        private int workDays;
        public TemporaryEmp() : base() {
            workDays = 0;
        }
        public TemporaryEmp(int         workDays,
                            int         empID, 
                            string      empName, 
                            DateTime    dob, 
                            string      department, 
                            int         numWork) 
            : base(empID, empName, dob, department, numWork) {
            this.workDays = workDays;
        }
        public override double CalculateSalary()
        {
            if (workDays <= 25) {
                return workDays * 50_000;
            } else 
            {
                return 25 * 50.000 + (workDays - 25) * 50.000 * 2;
            }
        }

    }
}
