using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
namespace BusOnlineTicket.Models
{   
    [Table("Buses")]
    public class Bus
    {
        [Key]
        public int Id { get; set; }

        [Required]
        [StringLength(10)]
        public string BusNumber { get; set; }

        [Required]
        [StringLength(50)]
        public string BusType { get; set; }

        [Required]
        [StringLength(255)]
        public string Route { get; set; }

        [Required]
        [Range(1, int.MaxValue)]
        public int TotalSeats { get; set; }
    }

}
