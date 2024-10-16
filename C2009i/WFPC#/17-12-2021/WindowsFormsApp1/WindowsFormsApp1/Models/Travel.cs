using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WindowsFormsApp1.Models
{
    public class Travel
    {
        public int TravelId { get; set; }
        public String Name { get; set; }
        public String From { get; set; }
        public String To { get; set; }
        public DateTime StartDate { get; set; }
        public Double Price { get; set; }

    }
}
