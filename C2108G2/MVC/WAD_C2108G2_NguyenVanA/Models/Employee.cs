using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace WAD_C2108G2_NguyenVanA.Models
{
    public class Employee
    {
        [Required]
        public int EmployeeId { get; set; }
        
        [Required]
        public string EmployeeName { get; set; }
        
        [Required]
        [DataType(DataType.Date)]
        [Display(Name = "Date of Birth")]
        public DateTime EmployeeDOB { get; set; }
        
        [Required]
        public string EmployeeDepartment { get; set; }

        public virtual ICollection<ProjectEmployee> ProjectEmployees { get; set; }
        public Employee()
        {
            ProjectEmployees = new HashSet<ProjectEmployee>();
        }
    }
}