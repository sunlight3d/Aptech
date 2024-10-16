using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EmployeeApp
{
    public class PersonTest
    {
        public void Test() {
            Person person1 = new Person("p123", "nguyen van a", 18);
            Person person2 = new Person("p2233", "tran van b", 33);
            PersonVietnam personVietnam = new PersonVietnam(2);
            personVietnam[0] = person1;
            personVietnam[1] = person2;//aList.get(10)//Java
            personVietnam.DisplayDetails();


        }
    }
}
