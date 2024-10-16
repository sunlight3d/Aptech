using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace de07
{
    internal class CatManagement : IAction<Cat>
    {
        private List<Cat> catList = new List<Cat>();
        public void Input() {
            while (true) {
                Cat cat = new Cat();
                cat.InputData();
                catList.Add(cat);
                Console.WriteLine("Do you want to continue ?");
                string answer = Console.ReadLine();
                if ((answer ?? "").ToLower().Trim().Equals("no")) {
                    break;
                }
            }
            Console.WriteLine("Input cats finished");
        }
        public Cat this[int index] {
            /*get => index < 0 || index >= catList.Count ?
                throw new ArgumentOutOfRangeException("out of range") : catList[index]; 
            */            
            get
            {
                if (index < 0 || index >= catList.Count) {
                    throw new ArgumentOutOfRangeException("out of range");
                }
                return catList[index];
            }
            set => throw new NotImplementedException(); 
        }

        public void AddToList(Cat item)
        {
            catList.Add(item);
        }

        public void Display()
        {
            foreach(Cat item in catList)
            {
                item.DisplayData();
            }
        }
    }

}
