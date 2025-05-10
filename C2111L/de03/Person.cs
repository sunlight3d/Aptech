using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace de03
{
    public class Person
    {
        private string _IDCard = "";
        string _name = "";
        int _age = 18;
        public string IDCard { get => _IDCard; }
        public string Name { get => _name; }
        public int Age { get => _age; }
        public Person(string iDCard, string name, int age)
        {
            _IDCard = iDCard;
            _name = name;
            _age = age;
        }
        public override string ToString()
        {
            return $"id card = {_IDCard}," +
                $" name: {_name} " +
                $" age: {_age} ";                
        }
    }
}
