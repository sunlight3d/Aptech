using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Web;
using WAD_C2203L_NguyenVanA.Models.Validations;

namespace WAD_C2203L_NguyenVanA.Models
{
    public class Employee
    {
        [Key]
        public int EmployeeId { get; set; }
        [Required]
        [StringLength(150, MinimumLength = 2)]
        public string EmployeeName { get; set; }

        [Required]
        [DataType(DataType.Date)]
        [MinimumAge(16, ErrorMessage = "Employee must be at least 16 years old.")]
        public DateTime EmployeeDOB { get; set; }

        [Required]
        [EmailAddress]
        public string Email { get; set; }

        
        [Required]
        public string EmployeeDepartment { get; set; }
        public virtual ICollection<ProjectEmployee> ProjectEmployees { get; set; }
    }
}