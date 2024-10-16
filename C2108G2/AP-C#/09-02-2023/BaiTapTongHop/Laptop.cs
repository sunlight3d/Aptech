using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BaiTapTongHop
{
    internal class Laptop : Product
    {
        private int _price;
        private float _vat;
        private string _stock;        
        public Laptop(int id) : base(id) { 
            _price = 0;
            _vat = 0.1f;
        }
        public Laptop(int id, string name, int price): base(id, name)
        {
            _price = price;
            _vat = 0.1f;
        }
        public void Input() {
            Console.WriteLine("input price :");
            Price = int.Parse(Console.ReadLine() ?? "0");


            Console.WriteLine("input name :");
            Name = Console.ReadLine() ?? "";

            Console.WriteLine("input stock :");
            Stock = Console.ReadLine() ?? "";

        }
        public int Price { 
            get => _price;
            
            set {
                if (value < 0) {
                    throw new Exception("Price must be >= 0");
                }
                _price = value;
            } 
        }
        public string  Stock { 
            get => _stock; 
            set => _stock = value; 
        }
        public int PriceCal { 
            get => (int)(_price*(1 + _vat)); 
        }
        public override void ShowInfo()
        {
            Console.WriteLine(
                $"Product id: {ID}, " +
                $"name: {Name}, "+
                $"price: {Price}, " +
                $"price include VAT: {PriceCal}, "+
                $"stock: {Stock}\n"
            );    
        }
    }
}
