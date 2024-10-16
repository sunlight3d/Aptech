using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProductApp
{
    public abstract class Product
    {
        private int _id;
        private string _name;

        public Product(int id)
        {
            _id = id;
            _name = "No name";
        }

        public Product(int id, string name)
        {
            _id = id;
            _name = name;
        }

        public int ID
        {
            get { return _id; }
        }

        public string Name
        {
            get { return _name; }
            set
            {
                if (value.Length < 3)
                {
                    throw new Exception("Product name must have a length of at least 3 characters.");
                }
                _name = value;
            }
        }

        public abstract void ShowInfo();//abstract method only contains name, not implementation
    }
}
