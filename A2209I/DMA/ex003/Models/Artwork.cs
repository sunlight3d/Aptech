using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Text.Json.Serialization;

namespace ex003.Models
{
    [Table("Artworks")]
    public class Artwork
    {
        [Key]
        public int ArtworkId { get; set; }
        [Required]
        [MaxLength(200, ErrorMessage = "Length must be <= characters")]
        public string Title { get; set; }

        public int Year { get; set; }

        // Foreign key
        [Required(ErrorMessage = "ArtistId is required.")]
        public int ArtistId { get; set; }

        // Navigation property
        [JsonIgnore]
        public virtual Artist Artist { get; set; }
    }
}
