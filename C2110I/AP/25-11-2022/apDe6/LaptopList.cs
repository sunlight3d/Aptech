using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace apDe6
{
    public class LaptopList
    {
        private List<Laptop> llist = new List<Laptop>();
        private int capacity;
        public LaptopList() { }
        public LaptopList(int capacity) {
            this.capacity = capacity;
            //indexer.Eg: objectA[2] 
        }
        public int Capacity { 
            get => capacity; 
            set => capacity = value; 
        }
        public Laptop this[int i]
        {
            get  {
                if (i < 0 || i >= capacity) {
                    throw new IndexOutOfRangeException("overrange of capacity");
                }

                return llist[i];
            }
            set {
                if (i < 0 || i >= capacity)
                {
                    throw new IndexOutOfRangeException("overrange of capacity");
                }
                llist[i] = value; 
            }
        }
        int Count {
            get => llist.Count;
        }
        public void Input() {
            //fake data
            Laptop laptop1 = new Laptop(1, "l1", 123, 0.3f);
            llist.Add(laptop1);
            Laptop laptop2 = new Laptop(2, "l2", 320, 0.5f);
            llist.Add(laptop2);
            Laptop laptop3 = new Laptop(3, "l3", 111, 0.2f);
            llist.Add(laptop3);
            /*
            for (var i = 0; i < capacity; i++) {
                Console.WriteLine($"Enter information of laptop {i + 1}");
                Laptop laptop = new Laptop();
                laptop.Input();
                llist.Add(laptop);
            }
            */
        }
        public void AddLaptop(Laptop laptop) {
            if (llist.Count >= this.capacity) {
                throw new Exception("No capacity for the new laptop");
            }
            llist.Add(laptop);
        }
        public void ShowFilterLaptops(float maxPrice) {
            llist.FindAll(laptop => laptop.PriceCal <= maxPrice)
                .ForEach(laptop => {
                    laptop.showInfo();
                });
        }
    }
}
