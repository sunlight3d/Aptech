using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace APDe07
{
    public class CatManagement : IAction<Cat>
    {
        private List<Cat> catList;
        public Cat this[int index] { 
            get => catList[index];
            set {
                if (index < 0 || index > catList.Count - 1) { 
                    throw new ArgumentOutOfRangeException("out of range");
                }
                catList[index] = value;
            }
        }

        public void AddToList(Cat item)
        {
            if (item != null) {
                catList.Add(item);
            }
            
        }

        public void Dislay()
        {
            Console.WriteLine("List of cats: ");
            catList.ForEach(item => item.Display());
        }
    }
}
