using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
namespace UserHub.Models
{
   
    public class BlogImage
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int ImageId { get; set; }

        [Required]
        [StringLength(255, ErrorMessage = "Image path cannot exceed 255 characters.")]
        public string ImagePath { get; set; }

        [DataType(DataType.DateTime)]
        [Display(Name = "Uploaded Date")]
        public DateTime UploadedAt { get; set; } = DateTime.UtcNow;

        // Navigation property
        [ForeignKey("Post")]
        public int BlogId { get; set; }
        public Post Post { get; set; }
    }

}
