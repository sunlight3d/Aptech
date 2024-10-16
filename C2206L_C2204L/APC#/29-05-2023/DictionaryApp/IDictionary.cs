using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DictionaryApp
{
    internal interface IDictionary
    {
        void AddWord(string word, string meaning);
        void EditWord(string word, string meaning);
        bool Remove(string word);
        void List();
        void Search(string word);
        //["hello","cat","mouse",....] => NO!, dung array
        //["xin chao", "con meo", "con chuot",...] => NO !, 
        //{"hello": "xin chao", "cat": "con meo",...},dung dictionary(HashMap trong java)

    }
}
