using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExamApp.models
{
    public class Employee
    {
        public int EmployeeID { get; set; }
        public int DepartmentID { get; set; }
        public string EmployeeName { get; set; }
        public int Gender { get; set; }
        //reference
        //
        public DateTime BirthDate { get; set; }
        public string Telephone { get; set; }
        public string Address { get; set; }

    }
}
