using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace De07
{
    internal class CatManagement : IAction<Cat>
    {
        private MyDbContext dbContext;
        private List<Cat> cats = new List<Cat>();
        public CatManagement(MyDbContext myDbContext) {
            this.dbContext= myDbContext;
            this.dbContext.Database.EnsureCreated();
            if (!dbContext.Cats.Any())
            {
                dbContext.Cats.Add(new Cat("mieo", 14, "grey"));
                dbContext.Cats.Add(new Cat("mimi", 12, "white"));
                dbContext.Cats.Add(new Cat("meoem moe", 16, "black"));                
                dbContext.SaveChanges();
            }
            cats = dbContext.Cats.ToList();
        }
       
        public Cat this[int index] { 
            get => cats[index];
            set {
                if (index < 0 || index > cats.Count - 1) {
                    throw new IndexOutOfRangeException("out of range");
                }
                cats[index] = value;
                this.dbContext.SaveChanges();
            } 
        }

        public void AddToList(Cat item)
        {
            if (item != null) {
                dbContext.Cats.Add(item);
                this.dbContext.SaveChanges();
            }
            
        }

        public void Display()
        {
            this.cats.ForEach(item => item.DisplayData());
        }
    }
}
