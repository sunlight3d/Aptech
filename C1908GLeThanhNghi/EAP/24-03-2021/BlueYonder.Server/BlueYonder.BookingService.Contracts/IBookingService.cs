using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.ServiceModel;
using BlueYonder.BookingService.Contracts.Faults;

namespace BlueYonder.BookingService.Contracts
{
    [ServiceContract(Namespace = "http://blueyonder.server.interfaces/")]
    public interface IBookingService
    {
        [OperationContract]
        [FaultContract(typeof(ReservationCreationFault))]
        string CreateReservation(ReservationDto request);
    }
}
