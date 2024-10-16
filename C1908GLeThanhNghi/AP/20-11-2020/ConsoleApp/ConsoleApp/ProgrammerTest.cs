using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp
{
    public class ProgrammerTest
    {
        public void Test() {
            int capacity;            
            Console.WriteLine("Enter number of Programmers : ");
            capacity = Convert.ToInt32(Console.ReadLine());
            HiredProgrammers hiredProgrammers = new HiredProgrammers(capacity);
            for(int i = 0; i < capacity; i++)
            {
                Console.WriteLine("Enter id = ");
            }
        }
        
        
    }
}
