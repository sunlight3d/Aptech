using Microsoft.Extensions.Hosting;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Text.Json.Serialization;

namespace ex003.Models
{
    [Table("Artists")]
    public class Artist
    {
        [Key]
        public int ArtistId { get; set; }
        [Required]
        [MaxLength(200, ErrorMessage ="Length must be <= characters")]
        public string Name { get; set; }
        public string Bio { get; set; }

        [JsonIgnore]
        public virtual ICollection<Artwork> Artworks { get; set; } = new List<Artwork>();
    }
}
