using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace ProjectAppMVC.Models
{
    public class ProjectEmployee
    {
        //[Key]
        public int Id { get; set; }
        [Required]
        public int EmployeeId { get; set; }
        [Required]
        public int ProjectId { get; set; }
        [Required]
        public string Tasks { get; set; }
        public virtual Employee Employee { get; set; }
        public virtual Project Project { get; set; }

        [NotMapped]
        public float SalaryFactor { get => 0.5f;}

        [NotMapped]
        public int NumberOfTasks { 
            get => Tasks.Split(new string[] { ", " }, 
            StringSplitOptions.None).Length; 
        } // Đánh dấu trường xx bằng [NotMapped]       
        
        [NotMapped]
        public float ActualSalary { get => Id * SalaryFactor; }
    }
}
