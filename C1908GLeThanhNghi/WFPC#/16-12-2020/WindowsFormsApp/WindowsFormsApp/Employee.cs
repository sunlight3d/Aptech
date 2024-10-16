using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WindowsFormsApp
{
    public class Employee
    {
        public string EmployeeName { get; set; }
        public string Address { get; set; }
        public string Position { get; set; }
        public string CurrentDepartmentName { get; set; }
        public List<string> DepartmentsWorked { get; set; }
    }
}
