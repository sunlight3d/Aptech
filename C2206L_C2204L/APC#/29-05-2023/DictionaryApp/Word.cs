using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DictionaryApp
{
    internal class Word : IWord
    {
        private string word = "";
        private string meaning = "";//field, variable
        public void Display()
        {
            Console.WriteLine($"word: {word}, meaning: {meaning}");//string concatenation
        }
    }
}
