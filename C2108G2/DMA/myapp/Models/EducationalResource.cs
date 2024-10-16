using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace myapp.Models
{
    [Table("educational_resources")]
    public class EducationalResource
    {
        [Key]
        [Column("resource_id")]
        public int ResourceId { get; set; }

        [Required]
        [Column("title")]
        public string Title { get; set; } = "";

        [Required]
        [Column("content")]
        public string Content { get; set; } = "";

        [Column("category")]
        public string Category { get; set; } = "";

        [Column("date_published")]
        public DateTime DatePublished { get; set; }
    }

}

