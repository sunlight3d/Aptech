using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace baitap004
{
    class TemporaryEmp:Employee
    {
        private int workDay;
        public TemporaryEmp(int _workDay):base() {
           workDay = _workDay;
        }
        public int WorkDay { get => workDay; set => workDay = value; }
        public TemporaryEmp(
            int _workDay,
            int _employeeID, 
            string _employeeName, 
            DateTime _dob, 
            string _department, 
            int  _numberOfWorking) : base(_employeeID, _employeeName, _dob, _department, _numberOfWorking)
        {
            this.workDay = _workDay;
        }

        public override int CalculateSalary()
        {
            if (workDay <= 0)
            {
                throw new ArgumentException("Invalid working days");
            }
            return workDay <= 25 ? workDay * 50000 : (25 * 50_000 + (workDay - 25) * 50_000 * 2);            
        }
        public override void Input() {
            base.Input();
            Console.WriteLine("Years of day of workings: ");
            this.workDay = int.Parse(Console.ReadLine() ?? "0");

        }
        public override void DisplayDetail()
        {
            base.DisplayDetail();
            Console.WriteLine($"working day: {workDay}\n" +
                $"salary: {CalculateSalary()}");
        }
    }
}
