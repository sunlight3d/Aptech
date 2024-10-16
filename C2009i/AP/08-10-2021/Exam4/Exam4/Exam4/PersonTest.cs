using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exam4
{
    public class PersonTest
    {
        public void Test()
        {
            Person person1 = new Person("id001", "nguyen van a", 18);
            Person person2 = new Person("id002", "nguyen van b", 19);
            PersonVietnam personVietNam = new PersonVietnam(2);
            personVietNam[0] = person1;
            personVietNam[1] = person2;
            personVietNam.DisplayDetails();
        }
    }
}
