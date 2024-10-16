using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Runtime.Serialization;
using BlueYonder.Entities;

namespace BlueYonder.BookingService.Contracts
{
    public class TripDto
    {
        [DataMember]
        public int FlightScheduleID { get; set; }
        [DataMember]
        public FlightStatus Status { get; set; }
        [DataMember]
        public SeatClass Class { get; set; }
    }
}
