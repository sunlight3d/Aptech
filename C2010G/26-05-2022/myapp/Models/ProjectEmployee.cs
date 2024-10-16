using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace myapp.Models
{
    public class ProjectEmployee
    {        
        [Key]
        public int EmployeeId { get; set; }
        [Required]
        public int ProjectId { get; set; }
        public string Tasks { get; set; }
        public Employee Employee { get; set;}
        public Project Project { get; set; }
    }
}