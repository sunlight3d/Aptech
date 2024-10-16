using System;
using System.Collections;
using exam1.models;
namespace exam1.models
{
    public class PersonVietnam
    {
        private ArrayList _persons;
        private int _length;
        public PersonVietnam(int length) {
            _length = length;
            _persons = new ArrayList(length);
            Console.WriteLine("kaka");
        }
        public Person this[int i]
        {
            get { return (Person)_persons[i]; }
            set {                                
                try
                {
                    if (i + 1 <= _length) {
                        _persons[i] = value;
                    }                                        
                }
                catch (ArgumentOutOfRangeException exception) {
                    _persons.Add(value);
                }
            }
        }
        public void DisplayDetails() {
            //Console.WriteLine($"Bill total:\t{billTotal,8:c}");
            foreach (Person person in _persons) {
                Console.WriteLine(person.ToString());
            }
        }
    }
}
