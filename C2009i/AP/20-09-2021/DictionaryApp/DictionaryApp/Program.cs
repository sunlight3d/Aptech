using System;
using System.Collections.Generic;

namespace DictionaryApp
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Dictionary program");
            MyDictionary myDictionary = new MyDictionary()
            {
                Dictionary = new Dictionary() { 
                    Words = new List<Word>(),
                }                
            };
            myDictionary.ShowMenu();
        }
    }
}
