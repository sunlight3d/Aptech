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
        public void InputCats() {
            string answer = "";
            while (true) {                
                Cat cat = new Cat();
                cat.InputData();
                catList.Add(cat);
                Console.WriteLine("Do you want to continue(yes, no)? ");
                answer = Console.ReadLine() ?? "";
                if (answer.Trim().ToLower().Equals("no"))
                {
                    break;
                }
                else if (answer.Trim().ToLower().Equals("yes"))
                {

                }
                else {
                    Console.WriteLine("Please enter yes or no !");              
                }
            }                       
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
