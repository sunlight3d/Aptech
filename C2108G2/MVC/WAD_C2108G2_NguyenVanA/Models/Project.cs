using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;
using WAD_C2108G2_NguyenVanA.Models.Validations;

namespace WAD_C2108G2_NguyenVanA.Models
{
    public class Project
    {
        [Key]
        [Required]
        public int ProjectId { get; set; }
        [Required]
        [StringLength(150, MinimumLength = 2, ErrorMessage ="Project's name must be 2-150")]
        public string ProjectName { get; set; }
        [Required]
        [DataType(DataType.Date)]
        [StartDateLessThanEndDate]
        public DateTime ProjectStartDate { get; set; }
        [Required]
        
        [DataType(DataType.Date)]
        [StartDateLessThanEndDate]
        public DateTime ProjectEndDate { get; set; }

        public virtual ICollection<ProjectEmployee> ProjectEmployees { get; set; }
        public Project() {
            ProjectEmployees = new HashSet<ProjectEmployee>();
        }
    }
}