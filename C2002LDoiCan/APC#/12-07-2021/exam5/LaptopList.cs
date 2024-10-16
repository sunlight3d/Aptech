using System.Collections.Generic;
using exam5.Models;
using System;
using System.Linq;
namespace exam5 {
    public class LaptopList {
        private List<Laptop> llist;
        int _capacity;
        public LaptopList(int capacity) {
            _capacity = capacity;
        }
        public Laptop this[int i]
        {
            get => i >= 0 && i < _capacity ? llist[i] 
                : throw new ArgumentOutOfRangeException("index must be <= capacity"); 
            set {
                if(i >= 0 && i < _capacity) {
                    llist[i] = value;
                }  else {
                    throw new ArgumentOutOfRangeException("index must be <= capacity");
                }
            }
        }
        public int Count { get => llist.Count;}
        public void AddLaptop(Laptop lab) {
            if(Count >= _capacity) {
                throw new ArgumentOutOfRangeException("Exceed capacity");                
            }
            llist.Add(lab);
        }
        public int ShowFilterLaptop(float maxprice) {
            //Linq = Language Integrated Query, hoi giong Stream trong java
            var filterList = llist.Where(eachLaptop => eachLaptop.Price <= maxprice).ToList();
            foreach(var laptop in filterList) {
                laptop.ShowInfo();
            }
            return filterList.Count();
        }

    }
}