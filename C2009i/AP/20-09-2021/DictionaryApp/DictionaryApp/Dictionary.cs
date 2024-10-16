using System;
using System.Collections.Generic;
using System.Linq;//LinQ(language integrated query) giong Stream Java
using System.Text;
using System.Threading.Tasks;

namespace DictionaryApp
{
    public class Dictionary : IDictionary
    {
        public List<Word> Words { get; set; }
        public void AddWord(string word, string meaning)
        {
            bool isExist = Words.Where(item => item._Word.Equals(word)).ToList().Count > 0;
            if (isExist)
            {
                Console.WriteLine("This word is existed");
            }
            else {
                Word newWordObject = new Word()
                {
                    _Word = word,
                    Meaning = meaning
                };
                Words.Add(newWordObject);
            }
        }

        public void EditWord(string word, string meaning)
        {
            //giong nhu Stream trong Java
            Word foundWord = this.Words.Where(item => item._Word.Equals(word)).FirstOrDefault();
            if (foundWord != null) {
                foundWord._Word = word;
                foundWord.Meaning = meaning;
            } else
            {
                Console.WriteLine($"Cannot find word: {word}");
            }

        }

        public void List()
        {
            Console.WriteLine("Your dictionary's content: ");
           foreach(Word word in this.Words) {
                word.Display();
           }
        }

        public bool Remove(string word)
        {
            
            Word foundWord = this.Words.Where(eachWord => eachWord._Word.Equals(word)).FirstOrDefault();
            //return this.Words.Remove(foundWord);
            
            if (foundWord != null) {
                this.Words.Remove(foundWord);
                Console.WriteLine($"Delete word: {word} successfully");
                return true;
            }
            Console.WriteLine("Cannot find Word to delete");
            return false;            
            /**
             * Microsoft: C/C++, C#, F#, Fortran(90% c++)
             * Google: Python, R(Machine Learning), Dart, Kotlin(mobile), Google script(90% javascript)
             * Apple: Swift, Objective C/C++
             */            
        }

        public void Search(string word)
        {            
            Word foundWord = this.Words.Where(item => item._Word.Equals(word)).FirstOrDefault();
            if (foundWord != null)
            {
                foundWord.Display();
            }
            else {
                Console.WriteLine("The word is not found");
            }
        }
    }
}
