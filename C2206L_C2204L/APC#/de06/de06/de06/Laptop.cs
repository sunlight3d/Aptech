using System;
namespace de06
{
	public class Laptop:Product, IGood
	{
        private int _price;
        private float _vat;
        private string _stock = "";

        public Laptop(int id) : base(id)
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
        public string Stock { get => _stock;
            set => _stock = value; }

        public float VAT => throw new NotImplementedException();

        public float PriceCal => _price*(1 + _vat);

        public override void ShowInfo()
        {
            Console.WriteLine($"price: {Price}, vat: {VAT}, stock: {Stock}");
        }
    }
}

