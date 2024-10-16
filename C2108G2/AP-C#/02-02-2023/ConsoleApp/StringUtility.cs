using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization.Formatters;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace ConsoleApp
{
    internal class StringUtility
    {
        /*
        public int CountWord(string s)
        {
            //string[] words = new Regex("\\s+").Split(s);
            
            return new Regex("\\s+").Split(s).Length;
        }
        */
        //oneline function(lambda expression)
        public int CountWord(string s) => new Regex("\\s+").Split(s).Length;


    }
}
