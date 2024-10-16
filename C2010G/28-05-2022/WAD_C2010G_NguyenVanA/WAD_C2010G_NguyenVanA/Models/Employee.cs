using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;
using WAD_C2010G_NguyenVanA.Validations;

namespace WAD_C2010G_NguyenVanA.Models
{
    public class Employee
    {
        [Key]
        public int EmployeeId { get; set; }
        [Required]
        [StringLength(150, MinimumLength =2, ErrorMessage ="Name must be 2 to 150 characters in length")]
        public string EmployeeName { get; set; }
        [Required]
        [DataType(DataType.DateTime, ErrorMessage="DOB must be Datetime")]
        
        [MinimumAgeAttribute(16)]
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