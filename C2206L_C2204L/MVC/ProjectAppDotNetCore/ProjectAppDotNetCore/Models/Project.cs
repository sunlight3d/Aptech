using ProjectAppDotNetCore.Validations;
using System.ComponentModel.DataAnnotations;

namespace ProjectAppDotNetCore.Models
{
    public class Project
    {
        [Key]
        public int ProjectId { get; set; }//property = getter / setter
        [Required]
        [StringLength(150, MinimumLength = 2, ErrorMessage = "Length must be 2 to 150")]
        public string ProjectName { get; set; }
        [Required]
        [ProjectDateValidation]
        public DateTime ProjectStartDate { get; set; }
        
        public DateTime? ProjectEndDate { get; set; }
        public virtual ICollection<ProjectEmployee> ProjectEmployees { get; set; }
        public Project() {
            ProjectEmployees = new HashSet<ProjectEmployee>();
        }

    }
}
