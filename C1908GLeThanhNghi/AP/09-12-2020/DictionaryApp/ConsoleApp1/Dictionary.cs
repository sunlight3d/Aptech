using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp1
{
    public class Dictionary: IDictionary
    {
        private Dictionary<string, string> myDictionary = new Dictionary<string, string>();
        public void AddWord(string word, string meaning) {
            //" Honag   " => "Honag"
            //    "      " => ""
            if (IsEmptyMeaning(meaning))
            { 
                Console.Error.WriteLine("Cannot add empty meaning");
                return;
            }
            if (myDictionary.ContainsKey(word))
            {
                Console.Error.WriteLine("Word exists, cannot add more");
            }
            else {
                myDictionary.Add(key: word, value: meaning);
            }
        }
        public bool IsEmptyMeaning(string meaning) => meaning == null || meaning.Trim().Length == 0;
        public bool IsEmptyWord(string word) => word == null || word.Trim().Length == 0;
        public bool WordExists(string word) => myDictionary.ContainsKey(word);
        public void EditWord(string word, string meaning)
        {
            if (IsEmptyMeaning(meaning))
            {
                Console.Error.WriteLine("Cannot use empty meaning");
                return;
            }
            if (myDictionary.ContainsKey(word))
            {
                myDictionary[word] = meaning;
            }
        }
        public bool Remove(string word)
        {
            try
            {
                if (myDictionary.ContainsKey(word))
                {
                    myDictionary.Remove(word);
                }
                Console.WriteLine("Delete word successfully");
                return true;
            }
            catch (Exception ex) {
                Console.Error.WriteLine($"Delete word failed : {ex.ToString()}");
                return false;
            }
            
        }
        public void List()
        {
            foreach (var word in myDictionary.Keys)
            {
                string meaning = myDictionary[word];
                Console.WriteLine($"{word} - {meaning}");
            }
        }
        public void Search(string word)
        {
            if (myDictionary.ContainsKey(word.Trim()))
            {
                Console.WriteLine($"{word} - {myDictionary[word]}");
            }
            else {
                Console.WriteLine("Cannot find meaning of this word!");
            }
        }
    }
}
