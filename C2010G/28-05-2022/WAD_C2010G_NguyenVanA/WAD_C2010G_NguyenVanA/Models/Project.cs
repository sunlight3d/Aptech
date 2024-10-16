using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;
using WAD_C2010G_NguyenVanA.Validations;

namespace WAD_C2010G_NguyenVanA.Models
{
    public class Project
    {
        [Key]
        public int ProjectId { get; set; } //property
        [Required]
        public string ProjectName { get; set; }
        [Required]
        //ProjectStartDate must<ProjectEndDate when ProjectEndDate is not NULL        
        //ModelState.AddModelError("Item3", "Item1 + Item2 must be less than Item3");
        public DateTime ProjectStartDate { get; set; }
        public DateTime? ProjectEndDate { get; set; } //nullable, optional
        //reference
        public virtual ICollection<ProjectEmployee> ProjectEmployees { get; set; }
        
        public Project()
        {
            ProjectEmployees = new HashSet<ProjectEmployee>();
        }

    }
}