using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExamApp
{

    public class Laptop : DeviceBase, IDevice
    {
        private int _price;
        private float _vat;
        private string _manufacturer = "";
        public Laptop(int id): base(id)
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
            set
            {
                if(value <=0 )
                {
                    throw new Exception("price must > 0");
                }
                else
                {
                    _price = value;
                }
            }
        }

        public string Manufacturer { 
            get => _manufacturer; 
            set => _manufacturer = value ?? ""; 
        }
        

        public float VAT => _vat;

        public float NetPrice => _price * (1 + _vat);

        public override void ShowInfo()
        {
            Console.WriteLine(  $"ProductId: {ID} | " +
                                $"Name: {Name} | " +
                                $"Price: {Price} | " +
                                $"Net Price: {NetPrice} | " +
                                $"Manufacturer: {Manufacturer}");
        }        
    }
}
