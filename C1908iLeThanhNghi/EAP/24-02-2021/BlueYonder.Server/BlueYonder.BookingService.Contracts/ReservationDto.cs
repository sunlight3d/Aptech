using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace BlueYonder.BookingService.Contracts
{
    public class ReservationDto
    {
        [DataMember]
        public int TravelerId { get; set; }
        [DataMember]
        public DateTime ReservationDate { get; set; }
        [DataMember]
        public TripDto DepartureFlight { get; set; }
        [DataMember]
        public TripDto ReturnFlight { get; set; }
    }
}
