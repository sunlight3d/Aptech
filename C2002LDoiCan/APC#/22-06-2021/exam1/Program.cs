using System;
using exam1.models;
using System.Collections;
using exam1.test;
namespace exam1
{
    class Program
    {
        static void Main(string[] args)
        {
            PersonTest personTest = new PersonTest();
            personTest.Test();

            //PersonVietnam personVietnam = new PersonVietnam(2);
            //Person person1 = personVietnam[0];
            //Console.WriteLine(person1.ToString());
        }
    }
}
