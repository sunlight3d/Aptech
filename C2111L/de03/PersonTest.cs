using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace de03
{
    internal class PersonTest
    {
        public static void Test() {
            PersonVietNam personVietNam = new PersonVietNam(2);
            personVietNam[0] = new Person("11111", "Nguyen va n a", 17);
            personVietNam[1] = new Person("22222", "Nguyen vaewewew a", 30);
            personVietNam.DisplayDetails();

        }
    }
}
