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
        private int     _price;//field = "variable"
        private float   _vat;
        private string  _stock = "";
        //encapsulation: fields are "private", properties(getter, setter) is "public"
        public Laptop():base() { }
        public Laptop(int id) : base(id)
        {
            this._price = 0;
            this._vat = 0.1f;
        }

        public Laptop(int id, string name, int price, float? vat) : base(id, name)
        {
            _price = price;
            _vat = vat ?? 0.1f;
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

        public float VAT => _vat; //getter

        public float PriceCal => _price * (1 + _vat);

        public override void Input() {
            base.Input();
            Console.WriteLine("Enter price");
            this._price = Convert.ToInt32(Console.ReadLine());

            Console.WriteLine("Enter VAT");
            this._vat = (float)Helper.InputDouble();

            Console.WriteLine("Enter stock");
            this._stock = Console.ReadLine() ?? "";
        }
        public override void showInfo() { 
            base.showInfo();
            Console.WriteLine($"price: "+this.Price+
                               $"Stock: "+this.Stock+
                               $"VAT: " + this.VAT+
                               $"calculated Price: " + this.PriceCal);
        }
    }
}
