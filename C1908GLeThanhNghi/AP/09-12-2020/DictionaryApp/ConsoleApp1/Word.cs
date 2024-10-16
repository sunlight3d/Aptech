using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp1
{
    public class Word: IWord
    {
        public String word { get; set; }
        public String meaning { get; set; }
        public void Display() {
            Console.WriteLine($"{word} : {meaning}");
        }
    }
}
