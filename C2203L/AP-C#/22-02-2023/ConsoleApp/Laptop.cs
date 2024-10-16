using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp
{
    public class Laptop : Product
    {
        private int _price;
        private float _vat;
        private string _stock;
        public Laptop(int id) : base(id)
        {
            _price = 0;
            _vat = 0.1f;
        }
        public Laptop(int id, string name, int price) : base(id, name)
        {
            _price = price;
            _vat = 0.1f;
        }
        public int Price { 
            get => _price; 
            set {
                if (value < 0) {
                    throw new Exception("price value cannot be < 0");
                } 
                _price = value;
            } 
        }
        public string Stock { get => _stock; set => _stock = value; }
        public float PriceCal { get => _price * (1 + _vat); }
        public override void ShowInfo()
        {
            Console.WriteLine(
                $"product id : {ID}, "+
                $"name : {Name}, " +
                $"Price: {Price}, " +
                $"price include VAT : {PriceCal}, " +
                $"Stock : {Stock}"                 
                );
        }
    }
}
