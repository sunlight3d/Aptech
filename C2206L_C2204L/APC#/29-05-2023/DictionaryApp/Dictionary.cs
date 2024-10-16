using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DictionaryApp
{
    internal class Dictionary : IDictionary
    {
        private Dictionary<string, string> dictionary = new Dictionary<string, string>();
        public void AddWord(string word, string meaning)
        {
            if (!dictionary.ContainsKey(word)) {
                Console.WriteLine("Do not contain this word");
                bool isValid = !string.IsNullOrEmpty(word) && !string.IsNullOrEmpty(meaning);
                if (isValid)
                {
                    dictionary.Add(word, meaning);
                }                    
            }
        }

        public void EditWord(string word, string meaning)
        {
            //can edit only value, but we need to edit key
            if (!string.IsNullOrEmpty(word)) {
                dictionary[word] = meaning;
            }
            
        }

        public void List()
        {
            foreach (KeyValuePair<string, string> kvp in dictionary)
            {
                string word = kvp.Key;
                string meaning = kvp.Value;
                // Xử lý key và value tại đây
                Console.WriteLine($"word: {word}, meaning: {meaning}");
            }
            /*
            foreach(var word in dictionary.Keys) {
                Console.WriteLine($"word: {word}, meaning: {dictionary[word]}");
            }
            */
            //for(int i = 0; i < dictionary.Count(); i++)
        }

        public bool Remove(string word) => dictionary.Remove(word);//lambda, one-line function, arrow function

        public void Search(string word)
        {
            if (dictionary.ContainsKey(word))
            {
                Console.WriteLine($"meaning: {dictionary[word]}");
            }
            else { 
                Console.WriteLine("Cannot find this word");
            }
        }
    }
}
