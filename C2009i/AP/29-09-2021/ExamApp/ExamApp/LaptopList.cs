using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExamApp
{
    public class LaptopList
    {
        private List<Laptop> LTList;
        public LaptopList(int capacity)
        {
            LTList = new List<Laptop>(capacity);
        }
        public int Count { get => LTList.Count; }
        public Laptop this[int i]
        {
            get {
                if (i >= Count)
                {
                    throw new Exception("Cannot get value,Out of capacity");
                }
                return LTList[i];
            }
            set {
                if (i >= Count)
                {
                    throw new Exception("Cannot set value, Out of capacity");
                }
                LTList[i] = value;
            }
        }
        public void AddLaptop(Laptop laptop)
        {
            try
            {
                LTList.Add(laptop);
            } catch (Exception ex)
            {
                throw new Exception($"Cannot add more laptop: {ex}");
            }
            
        }
        public int ShowFilterLaptop(float maxprice)
            => LTList.Where(eachLaptop => eachLaptop.NetPrice <= maxprice).ToList().Count;

    }
}
