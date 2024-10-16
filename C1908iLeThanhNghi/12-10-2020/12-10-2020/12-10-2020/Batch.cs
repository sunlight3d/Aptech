using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace _12_10_2020
{
    public class Batch
    {        
        private ArrayList studentNames = new ArrayList();
        MyDelegate Warning = (string input) => {
            Console.WriteLine("Please enter letters or space only ");
        };
        public event MyDelegate myEvent;
        public void AddStudent(String name) {
            if (name.Any(character => !Char.IsLetterOrDigit(character))) {
                //co ky tu dac biet
                myEvent += Batch_myEvent;
                myEvent.Invoke(name);
            }
        }
        private void Batch_myEvent(string input)
        {
            Warning(input);
        }
    }
}
