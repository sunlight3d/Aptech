using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace WAD_C2110i_NguyenVanA.Models
{
    public class Project
    {
        public int ProjectId { get; set; }
        [Required]
        public string ProjectName { get; set; }
        [Required]
        [DataType(DataType.Date)]
        public DateTime ProjectStartDate { get; set; }
        [Required]
        [DataType(DataType.Date)]
        public DateTime? ProjectEndDate { get; set; }
        public Project() {
            ProjectEmployees = new HashSet<ProjectEmployee>();
        }

        public virtual ICollection<ProjectEmployee> ProjectEmployees { get; set; }
    }
}