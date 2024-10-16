using System.ComponentModel.DataAnnotations;

namespace WebMVCAppDotnet6.Models
{
    public class Category
    {
        [Key]
        public int Id { get; set; }
        [Required]
        [StringLength(maximumLength:100, MinimumLength =3, ErrorMessage ="Length must be 3 to 100")]
        public string Name { get; set; }
        public int DisplayOrder { get; set; }
        [Required]
        [DataType(DataType.DateTime, ErrorMessage ="This must be datetime")]
        public DateTime CreatedDateTime { get; set; } = DateTime.Now;
    }
}
