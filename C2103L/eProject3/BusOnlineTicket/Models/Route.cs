using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
namespace BusOnlineTicket.Models
{    
    [Table("Routes")]
    public class Route
    {
        [Key]
        public int Id { get; set; }

        [Required]
        [StringLength(255)]
        public string RouteName { get; set; }

        [Required]
        [StringLength(255)]
        public string Departure { get; set; }

        [Required]
        [StringLength(255)]
        public string Destination { get; set; }

        [Required]
        public float Distance { get; set; }
    }

}
