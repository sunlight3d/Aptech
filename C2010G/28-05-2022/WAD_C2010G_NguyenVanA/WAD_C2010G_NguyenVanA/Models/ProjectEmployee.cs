using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace WAD_C2010G_NguyenVanA.Models
{
    public class ProjectEmployee
    {
        public int ID { get; set; }
        public int EmployeeId { get; set; }        
        public int ProjectId { get; set; }
        [Required]
        public string Tasks { get; set; }
        public Employee Employee { get; set; }
        public Project Project { get; set; }
    }
}