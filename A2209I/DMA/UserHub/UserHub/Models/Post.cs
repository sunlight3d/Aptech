using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
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

        // Foreign key
        [Required(ErrorMessage = "User ID is required.")]
        public int UserId { get; set; }

        // Navigation property
        public virtual User User { get; set; }
    }



}
