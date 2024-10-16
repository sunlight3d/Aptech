using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExamApp.models
{
    public class Employee
    {
        public string EmployeeName { get; set; }
        public int Gender { get; set; }
        //reference
        //
        public DateTime DateOfBirth { get; set; }
        public string Telephone { get; set; }
        public string Address { get; set; }

    }
}
