namespace BusOnlineTicket.Models
{
    using System;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;

    [Table("Schedule")]
    public class Schedule
    {
        [Key]
        public int Id { get; set; }

        [Required]
        public int BusId { get; set; }

        [ForeignKey("BusId")]
        public Bus Bus { get; set; }

        [Required]
        public int RouteId { get; set; }

        [ForeignKey("RouteId")]
        public Route Route { get; set; }

        [Required]
        [DataType(DataType.DateTime)]
        public DateTime DepartureTime { get; set; }

        [Required]
        [DataType(DataType.DateTime)]
        public DateTime ArrivalTime { get; set; }
    }

}
