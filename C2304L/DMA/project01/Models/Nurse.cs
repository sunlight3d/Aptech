using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;
using System.Text.Json.Serialization;

namespace project01.Models
{
    public class Nurse
    {
        // Setting NurseId as the primary key and enabling auto-increment
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int NurseId { get; set; }

        // Ensuring the Name is required and setting the maximum length to 100 characters
        [Required]
        [StringLength(100, ErrorMessage = "Name cannot exceed 100 characters")]
        public string Name { get; set; }

        // Certification details are required
        [Required(ErrorMessage = "Certification details are required")]
        public string Certification { get; set; }

        // WardId as a foreign key to the Ward table
        [ForeignKey("Ward")]
        public int WardId { get; set; }

        // Navigation property to the Ward entity
        [JsonIgnore]
        public virtual Ward? Ward { get; set; }
    }
}
