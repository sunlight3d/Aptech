using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Transactions;

namespace apDe6
{
    public class Laptop : Product, IGood
    {
        private int _price;
        private float _vat;
        private string _stock = "";
        public Laptop(int id) : base(id)
        {
            this._price = 0;
            this._vat = 0.1f;
        }

        public Laptop(int id, string name, int price) : base(id, name)
        {
            _price = price;
            _vat = 0.1f;
        }        

        public int Price { get => _price;
            set {
                if (value < 0) {
                    throw new Exception("Value cannot be < 0");
                }
                this._price = value;
            }
        }
        public string Stock { 
            get => _stock; 
            set => _stock = value; 
        }

        public float VAT => _vat;

        public float PriceCal => _price * (1 + _vat);

        public override void showInfo() { 
            base.showInfo();
            Console.WriteLine($"price: "+this.Price+
                               $"Stock: "+this.Stock+
                               $"VAT: " + this.VAT);
        }
    }
}
