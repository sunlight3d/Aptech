using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EmployeeManagementApp.Models
{
    public class  Employee
    {
        public int EmployeeId { get; set; }
        public string EmployeeName { get; set; }
        public bool Gender { get; set; }
        public DateTime BirthDate { get; set; }
        public string Telephone { get; set; }
        public string Address { get; set; }
        public string DeparmentId { get; set; } //foreign key
    }
}
