using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace BlueYonder.Flights.Models
{
    public class Room
    {
        public int RoomId { get; set; }
        public int Number { get; set; }
        public decimal Price { get; set; }
        public bool Available { get; set; }
        public ICollection<Booking> Bookings { get; set; } = new List<Booking>();
    }
}
