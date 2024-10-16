using System;
using System.Collections.Generic;
using System.Text;

namespace InterfaceExample
{
    public class Student:IPlayable, ILearning
    {
        public int RollNumber { get; set; }
        public string Name { get; set; }
        public int YearOfBirth { get; set; }

        public void gotoLibrary()
        {
            Console.WriteLine("I go to the library");
        }

        public void playFootball()
        {
            Console.WriteLine("I play football");
        }
        public void ReadBook(string bookName) {
            Console.WriteLine($"I am reading {bookName}");
        }
        
    }
}
