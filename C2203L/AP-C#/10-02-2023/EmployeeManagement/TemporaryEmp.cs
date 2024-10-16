using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EmployeeManagement
{
    internal class TemporaryEmp : Employee
    {
        private int workDay;
        public TemporaryEmp() : base() {
            //super();Java
            workDay = 0;
        }
        public TemporaryEmp(int         empID,
                            string      empName,
                            DateTime    dob,
                            string      department,
                            int         numWork,
                            int         workDay) : base(
                                                empID, 
                                                empName, 
                                                dob, 
                                                department, 
                                                numWork
                           ) {
            this.workDay = workDay;
        }
        public override void Input() {
            base.Input();
            Console.WriteLine("Enter the workDay: ");
            workDay = Convert.ToInt32(Console.ReadLine());
        }
        public override void DisplayDetail()
        {
            base.DisplayDetail();
            Console.WriteLine($"\nworkDay: {workDay}");
        }
        public override double CalculateSalary()
                            => workDay <= 25 ? workDay* 50_000 :
                                    25*50_000 + (workDay - 25) * 50000 * 2;
    }
}
