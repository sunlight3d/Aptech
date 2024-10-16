using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp
{
    public abstract class Product
    {
        private int _id;
        private string _name;
        public Product(int id) { 
            _id = id;
            _name = "No name";
        }
        public Product(int id, string name)
        {
            _id = id;
            _name = name;
        }
        public int ID { get => _id;  }
        public string Name { get => _name; 
            set {
                if (value.Length < 3) {
                    throw new Exception("Name must be >=3 characters in length");
                }
                _name = value;
            } 
        }
        public abstract void ShowInfo();
    }
}
