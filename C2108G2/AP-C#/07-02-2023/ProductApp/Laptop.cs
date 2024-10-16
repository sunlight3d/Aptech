using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProductApp
{
    internal class Laptop : Product, IGood
    {
        private int _price;
        private float _vat;
        private string _stock;

        public Laptop(int id) : base(id)
        {
            _price = 0;
            _vat = 0.1f;

        }
        public Laptop(int id, string name) : base(id, name)
        {
            _price = 0;
            _vat = 0.1f;
        }

        public int Price { get => _price; set {
                if (value < 0) {
                    throw new Exception("Price cannot be < 0");
                }
                _price = value;
            } 
        }
        public string Stock { get => _stock; set { 
                _stock = value;
            }
        }

        public float VAT => _vat;

        public float PriceCal => throw new NotImplementedException();

        public override void ShowInfo()
        {
            throw new NotImplementedException();
        }
    }
}
