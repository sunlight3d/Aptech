using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;
using System.Xml.Linq;

namespace project01.Models
{
    public class Ward
    {
        // Setting the WardId as the primary key and enabling auto-increment
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int WardId { get; set; }

        // Ensuring the Name is required and setting the maximum length to 100 characters
        [Required]
        [StringLength(100, ErrorMessage = "Name cannot exceed 100 characters")]
        public string Name { get; set; }

        // Capacity of the ward; no specific validation rules are mentioned for this field beyond being a required non-negative number
        [Required(ErrorMessage = "Capacity is required")]
        [Range(1, int.MaxValue, ErrorMessage = "Capacity must be at least 1")]
        public int Capacity { get; set; }

        public virtual ICollection<Nurse>? Nurses { get; set; }

    }
}
