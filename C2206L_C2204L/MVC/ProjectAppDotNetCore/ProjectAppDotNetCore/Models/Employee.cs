using Microsoft.EntityFrameworkCore;
using ProjectAppDotNetCore.Validations;
using System.ComponentModel.DataAnnotations;

namespace ProjectAppDotNetCore.Models
{
    public class Employee
    {
        [Key]
        public int EmployeeId { get; set; }
        [Required]
        [StringLength(150, MinimumLength =2, ErrorMessage = "Length must be 2 to 150")]
        
        public string EmployeeName { get; set; }
        [Required]
        [DataType(DataType.DateTime)]
        [EmployeeAgeValidation]
        public DateTime EmployeeDOB { get; set; }
        //string
        //EmployeeDepartment get; set; ??
        public virtual ICollection<ProjectEmployee> ProjectEmployees { get; set; }
        public Employee() {
            ProjectEmployees = new HashSet<ProjectEmployee>();
        }


    }
}
