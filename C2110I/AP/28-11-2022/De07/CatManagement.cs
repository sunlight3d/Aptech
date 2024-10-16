using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace De07
{
    internal class CatManagement:IAction<Cat>
    {
        private List<Cat> catList = new List<Cat>();

        public Cat this[int index] { get {
                if (index < 0 || index >= catList.Count) { 
                    throw new ArgumentOutOfRangeException("out of range");
                }
                return catList[index];
            }
            set {
                if (index < 0 || index >= catList.Count)
                {
                    throw new ArgumentOutOfRangeException("out of range");
                }
                catList[index] = value;
            } 
        }

        public void AddToList(Cat item)
        {
            this.catList.Add(item);
        }

        public void Display()
        {
            /*
            for (var i = 0; i < this.catList.Count; i++) { 
                Cat cat = this.catList[i];
            }
            */
            foreach(Cat cat in this.catList)
            {
                cat.DisplayData();
            }
            //this.catList.ForEach(cat => cat.DisplayData());
        }
    }
}
