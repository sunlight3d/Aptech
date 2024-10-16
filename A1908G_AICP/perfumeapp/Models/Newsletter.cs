using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;

namespace perfumeapp.Models
{
    public class Newsletter
    {
        [Key]
        public int NewsletterID { get; set; }

        [ForeignKey("User")]
        public int UserID { get; set; }

        [Required]
        [StringLength(100)]
        [EmailAddress]
        public string Email { get; set; }

        public virtual User User { get; set; }
    }
}
