using System;
using System.Collections.Generic;
using System.Diagnostics.Metrics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace de03
{
    public class PersonVietNam
    {
        private int _size;
        private Person[] persons;

        public PersonVietNam(int size)
        {
            _size = size;
            //persons = new List<Person>(size);
            persons = new Person[size];
                 
        }
        public Person this[int index]
        {
            get
            {
                if (index < 0) throw new IndexOutOfRangeException("Cannot index less than 0");
                if (index >= _size) throw new IndexOutOfRangeException("Cannot index past the end of storage");
                return persons[index];
            }
            set
            {
                if (index < 0) throw new IndexOutOfRangeException("Cannot index less than 0");
                if (index >= _size) throw new IndexOutOfRangeException("Cannot index past the end of storage");                
                persons[index] = value;
            }
        }
        public void DisplayDetails() {
            foreach (Person person in persons) {
                Console.WriteLine(person);
            }
        }
    }
}
