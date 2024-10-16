using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exam3
{
    class TemporaryEmp : Employees
    {
        private int workDay;
        public int WorkDay { get => workDay; set => workDay = value; }
        public TemporaryEmp(): base()
        {
            this.workDay = 0;
        }
        public TemporaryEmp(
            int employeeID,
            string employeeName,
            DateTime dob,
            string department,
            int numWork,
            int workDay) : base(employeeID,
                        employeeName,
                        dob,
                        department,
                        numWork)
        {
            this.workDay = workDay;
        }
        public override double CalculateSalary() =>
            workDay <= 25 ? workDay * 50_000 : (25 * 50_000 + (workDay - 25) * 50_000 * 2);
        public override void Input()
        {
            base.Input();
            Console.WriteLine("Input worDay: ");
            workDay = Convert.ToInt32(Console.ReadLine());
        }
        public override void DisplayDetail()
        {            
            base.DisplayDetail();
            Console.WriteLine($"workDay: {workDay}");
        }
    }
}
