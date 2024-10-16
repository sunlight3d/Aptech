using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace myapp.Models
{
    public class Project
    {
        [Key]
        public int ProjectId { get; set; } //property
        public string ProjectName { get; set; }
        public DateTime ProjectStartDate { get; set; }
        public DateTime? ProjectEndDate { get; set; } //nullable, optional
        //reference
        public virtual ICollection<ProjectEmployee> ProjectEmployees { get; set; }
        public Project() {
            ProjectEmployees = new HashSet<ProjectEmployee>();
        }
        
    }
}