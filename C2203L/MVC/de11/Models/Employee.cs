using System.ComponentModel.DataAnnotations;

namespace de11.Models
{
    public class Employee
    {
        [Key]
        public int EmployeeNo { get; set; }
        public string EmployeeName { get; set; }
        public string Position { get; set; }
        public int Salary { get; set; }
    }
}
