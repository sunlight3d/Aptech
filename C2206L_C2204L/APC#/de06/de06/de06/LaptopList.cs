using System;
namespace de06
{
	public class LaptopList
	{
		private List<Laptop> llist;
        private int _capacity = 0;
		public LaptopList(int capacity) {
			llist = new List<Laptop>(capacity);
            _capacity = capacity;
		}
        public Laptop this[int index]
        {
            get {
                if (index < 0 || index >= _capacity) {
                    throw new Exception("Out of range");
                }
                return llist[index];
            }
            set {
                if (index < 0 || index >= _capacity)
                {
                    throw new Exception("Out of range");
                }
                llist[index] = value;
            }
        }
        public void AddLaptop(Laptop laptop) {
            if (llist.Count >= _capacity) {
                throw new Exception("laptop is enough");
            }
            llist.Add(laptop);
        }
        public void ShowFilterlaptop(float maxPrice) {
            llist.Where(laptop => laptop.PriceCal <= maxPrice)
                .ToList().ForEach(laptop => Console.WriteLine(laptop));
        }
    }
}

