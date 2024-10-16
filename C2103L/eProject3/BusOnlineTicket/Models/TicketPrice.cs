namespace BusOnlineTicket.Models
{
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;

    [Table("TicketPrices")]
    public class TicketPrice
    {
        [Key]
        public int Id { get; set; }

        [Required]
        [StringLength(50)]
        public string BusType { get; set; }

        [Required]
        public float DistanceFrom { get; set; }

        [Required]
        public float DistanceTo { get; set; }

        [Required]
        public float Price { get; set; }
    }

}
