using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BaiTapTongHop
{
    internal abstract class Product
    {

        public int _id;
        private string _name;//fields

        public int ID { get => _id; }
        public string Name { get => _name; set {
                if (value.Length < 3)
                {
                    throw new Exception("name must be >=3 characters");
                }
                _name = value;

            } 
        }
        public Product(int id) {
            _name = "No name";
        }

        public Product(int id, string name)
        {
            _id = id;
            _name = name;
        }
        public abstract void ShowInfo();
    }
}
