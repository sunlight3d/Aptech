using System;
using exam1.models;
namespace exam1.test
{
    public class PersonTest
    {
        public void Test()
        {
            Person person1 = new Person("113831", "Ha Khanh Toan", 29);
            Person person2 = new Person("237438", "Tran Khanh", 36);
            PersonVietnam personVietnam = new PersonVietnam(2);
            personVietnam[0] = person1;
            personVietnam[0] = person1;
            personVietnam[1] = person2;

        }
    }
}
