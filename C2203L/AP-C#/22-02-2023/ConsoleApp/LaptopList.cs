using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp
{
    public class LaptopList
    {
        private List<Laptop> llist;
        public int Count { get => llist.Count; }
        public LaptopList(int capacity) { 
            llist = new List<Laptop>(capacity);
        }
        public Laptop this[int index]
        {
            get
            {
                if (index < 0 || index >= llist.Count) { 
                    throw new IndexOutOfRangeException("out of range");
                }
                return llist[index];
            }
            set
            {
                if (index < 0 || index >= llist.Count)
                {
                    throw new IndexOutOfRangeException("out of range");
                }
                llist[index] = value;
            }
        }

    }
}
