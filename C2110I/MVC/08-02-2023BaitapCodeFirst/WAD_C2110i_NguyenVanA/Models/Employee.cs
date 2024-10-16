using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace WAD_C2110i_NguyenVanA.Models
{
    public class Employee
    {
        public int EmployeeId { get; set; }
        
        [Required]
        public string EmployeeName { get; set; }
        [Required]
        [DataType(DataType.Date)]
        //check 16 years => Custom validation 
        [EmployeeDOBValidation]
        public DateTime EmployeeDOB { get; set; }
        [Required]
        public string EmployeeDepartment { get; set; }
        public Employee() {
            ProjectEmployees = new HashSet<ProjectEmployee>();
        }

        public virtual ICollection<ProjectEmployee> ProjectEmployees { get; set; }
    }
}