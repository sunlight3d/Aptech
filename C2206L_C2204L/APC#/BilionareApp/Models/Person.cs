using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BilionareApp.Models
{
     class Person
    {
        public String? Name { get; set; }
        public String? Nationality { get; set; }
        public int BirthYear { get; set; }
        public float NetWorth { get; set; }
        public override string ToString()
        {
            return $"Name: {Name}, " +
                $"Nationality: {Nationality}," +
                $"BirthYear: {BirthYear}," +
                $" NetWorth: {NetWorth}";
        }
    }
}
