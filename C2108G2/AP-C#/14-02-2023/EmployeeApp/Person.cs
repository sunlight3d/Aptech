using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace EmployeeApp
{
    public class Person
    {
        private string _IDCard;
        private string _name;
        private int _age;
        public string  IDCard { get => _IDCard; }
        public string Name { get => _name; }
        public int Age { get => _age; }
        
        public Person(string iDCard, string name, int age)
        {
            _IDCard = iDCard;
            _name = name;
            _age = age;
        }
        
        public override string ToString() =>
                $"idcard : {IDCard}, \n" +
                $"name : {Name}, \n" +
                $"age : {Age}, \n";
    }
}
