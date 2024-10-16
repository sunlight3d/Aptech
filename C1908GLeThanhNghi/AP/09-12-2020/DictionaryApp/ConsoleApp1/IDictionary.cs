using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp1
{
    public interface IDictionary
    {
        public void AddWord(string word, string meaning);
        public void EditWord(string word, string meaning);
        public bool Remove(string word);//boolean
        public void List();
        public void Search(string word);
    }
}
