using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EmployeeApp
{
    class PersonVietnam
    {
        private Person[] persons ;
        public PersonVietnam(int capacity) {
            persons = new Person[capacity];
        }
        public Person this[int i] //indexer, mutating 
        {
            get { return persons[i]; }
            set { persons[i] = value; }
        }
        public void DisplayDetails() {            
            persons.ToList().ForEach(person => Console.WriteLine(person.ToString()));
        }
    }
}
