using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exam4
{
    public class PersonVietnam
    {
        private Person[] persons;     
        public PersonVietnam(int capacity)
        {             
            persons = new Person[capacity];          
        }
        //indexer
        public Person this[int i]
        {
            get {
                if (i < 0 || i >= persons.Length)
                {
                    throw new Exception("Out of range");
                }
                return persons[i];
            }
            set {
                if (i < 0 || i >= persons.Length)
                {
                    throw new Exception("Out of range");
                }                
                persons[i] = value;
            }                
        }
        public void DisplayDetails()
        {
            Console.WriteLine("Person Vietnam:");
            Console.WriteLine("ID Card      Full Name       Age");
            Console.WriteLine("--------     ---------       -----");
            foreach(Person person in persons)
            {
                Console.WriteLine(person.ToString());
            }            

        }
    }
}
