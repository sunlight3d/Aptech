using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DictionaryApp
{
    public class Word : IWord //Java => class Word implements IWord
    {
        public string _Word { get; set; }
        public string Meaning { get; set; }
        public void Display()
        {
            Console.WriteLine($"Word: {_Word}, Meaning: {Meaning}");
        }
    }
}
