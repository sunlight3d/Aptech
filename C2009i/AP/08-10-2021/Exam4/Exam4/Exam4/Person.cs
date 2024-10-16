using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exam4
{
    public class Person
    {
        private string _IDCard;
        private string _name;
        private int _age;
        public string IDCard { get => _IDCard;  }
        public string Name { get => _name; }
        public int Age { get => _age;}
        //record type
        public Person(string idCard, string name, int age)
        {
            _IDCard = idCard;
            _name = name;
            _age = age;
        }
        public override string ToString()
        {
            return $"{IDCard}       {Name}      {Age}";
        }
    
    }
}
