using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace BlueYonder.Flights.Models
{
    public class Hotel
    {
        public int HotelId { get; set; }
        public string Name { get; set; }
        public string Address { get; set; }
        public ICollection<Room> Rooms { get; set; }
    }
}
