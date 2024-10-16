using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BaiTapTongHop
{
    internal class LaptopList
    {
        private List<Laptop> llist;
        private int _capacity;
        public LaptopList(int capacity) {            
            _capacity = capacity;
            llist = new List<Laptop>(capacity);
        }
        public Laptop this[int index]
        {
            get {
                if (index >= llist.Count) {
                    throw new IndexOutOfRangeException("Out of range");
                }
                return llist[index];
            }
            set {
                if (index >= _capacity)
                {
                    throw new IndexOutOfRangeException("Out of range");
                }
                llist[index] = value; 
            }
        }
        public void AddLaptop(Laptop laptop) {
            if (llist.Count >= _capacity) {
                throw new Exception("Out of capacity");
            }
            llist.Add(laptop);
        }
        public void ShowFilterLaptop(float maxprice) {
            llist.Where(item => item.PriceCal <= maxprice)
                .ToList()
                .ForEach(item =>
            {                
                item.ShowInfo();
            });
        }
        public void Input()
        {
            for (int i = 0; i < _capacity; i++) {                
                Laptop laptop = new Laptop(i+ 1);
                Console.WriteLine($"Input laptop {i + 1}");
                laptop.Input();
                AddLaptop(laptop);
            }
        }
    }
}
