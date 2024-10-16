using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace De03
{
    internal class Person
    {
        private string _IDCard;
        private string _name;
        private int _age;
        public string IDCard {
            get => _IDCard;
        }
        public string Name { 
            get => _name;
        }
        public int Age {
            get => _age;
        }
    }
}
