using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace myapp.Models
{
    public class Employee    
   {
        [Key]
        public int EmployeeId { get; set; }
        public string EmployeeName { get; set; }    
        public DateTime EmployeeDOB { get; set; }
        public string EmployeeDepartment { get; set; }
        public virtual ICollection<ProjectEmployee> ProjectEmployees { get; set; }
        public Employee() {
            ProjectEmployees = new HashSet<ProjectEmployee>();
        }



    }
}