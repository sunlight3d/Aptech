using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace WAD_C2108G2_NguyenVanA.Models
{
    public class ProjectEmployee
    {
        [Key]
        public int Id { get; set; }
        //public string ProjectEmployeeId { get => $"{EmployeeId}{ProjectId}"; set; }
        public int EmployeeId { get; set; }
        public int ProjectId { get; set; }
        
        [Required]
        public string Tasks { get; set; }
        public virtual Project Project { get; set; }
        public virtual Employee Employee { get; set; }
    }
}