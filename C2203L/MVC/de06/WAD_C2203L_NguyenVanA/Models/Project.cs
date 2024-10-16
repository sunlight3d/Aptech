using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;
using System.Xml.Linq;
using WAD_C2203L_NguyenVanA.Models.Validations;

namespace WAD_C2203L_NguyenVanA.Models
{
    public class Project
    {
        [Key]
        public int ProjectId { get; set; }
        [Required]
        public string ProjectName { get; set; }
        [Required]
        [DataType(DataType.Date)]

        public DateTime ProjectStartDate { get; set; }
        
        [Required]
        [Display(Name = "End Date")]
        [DataType(DataType.Date)]
        [GreaterThan("ProjectStartDate", ErrorMessage = "End date must be greater than start date.")]
        public DateTime ProjectEndDate { get; set; }
        public virtual ICollection<ProjectEmployee> ProjectEmployees { get; set; }
    }
}