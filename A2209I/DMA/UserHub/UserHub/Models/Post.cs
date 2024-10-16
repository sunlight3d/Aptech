using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Text.Json.Serialization;
using static System.Net.Mime.MediaTypeNames;
namespace UserHub.Models
{
    [Table("Posts")]
    public class Post
    {
        public int Id { get; set; }

        [Required(ErrorMessage = "Title is required.")]
        [StringLength(100, MinimumLength = 3, ErrorMessage = "Title must be between 3 and 100 characters.")]
        public string Title { get; set; }

        [Required(ErrorMessage = "Content is required.")]
        [StringLength(1000, ErrorMessage = "Content must not exceed 1000 characters.")]
        public string Content { get; set; }

        [DataType(DataType.DateTime)]
        [Display(Name = "Created Date")]
        public DateTime CreatedAt { get; set; } = DateTime.UtcNow;

        [DataType(DataType.DateTime)]
        [Display(Name = "Updated Date")]
        public DateTime? UpdatedAt { get; set; }

        // Foreign key
        [Required(ErrorMessage = "User ID is required.")]
        public int UserId { get; set; }

        // Navigation property
        [JsonIgnore]
        public virtual User User { get; set; }
        // Collection to hold related images
        public virtual ICollection<BlogImage> BlogImages { get; set; } = new List<BlogImage>();
    }



}
