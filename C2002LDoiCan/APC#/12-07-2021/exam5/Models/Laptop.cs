using System;
namespace exam5.Models {
    public class Laptop : Product, IGood
    {
        private int _price;
        private float _vat;
        private string _stock;
        public Laptop(int id) : base(id)
        {
            _price = 0;
            _vat = 0.1f;

        }
        public Laptop(int id, string name, int price): base(id, name)
        {
            _price = price;
        }


        public int Price { get => _price; set => value = _price; }
        public string Stock { get => _stock; set => value = _stock; }
        public float VAT { get => _vat; }
        public float PriceCal { get => _price * (1 + _vat); }

        public override void ShowInfo()
        {
            Console.WriteLine($"Product id: {ID}, name= {Name},price = {_price}, price in VAT: {PriceCal}");
        }
    }
}