using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;

namespace bai01.Models
{
    [Table("Post")]
    public class Post
    {
        [Key]
        public int Id { get; set; }

        [Required]
        [StringLength(255, MinimumLength = 5)]
        public string Title { get; set; }

        public string Content { get; set; }

        [Required]
        [StringLength(100)]
        public string Author { get; set; }

        public DateTime PublishedDate { get; set; }

        [ForeignKey("Category")]
        public int CategoryId { get; set; }
        public virtual Category Category { get; set; }
    }
}
