using System.Security.Cryptography.Xml;
using System.Security.Principal;

namespace BusOnlineTicket.Models
{
    using System;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;

    [Table("Tickets")]
    public class Ticket
    {
        [Key]
        public int Id { get; set; }

        [Required]
        public int CustomerId { get; set; }
        public virtual Customer Customer { get; set; }

        [Required]
        public int ScheduleId { get; set; }
        public virtual Schedule Schedule { get; set; }

        [Required]
        public int SeatNumber { get; set; }

        [Required]
        public float Price { get; set; }

        [Required]
        public DateTime BookingDate { get; set; }

        [Required]
        [StringLength(50)]
        public string Status { get; set; }
    }

}
