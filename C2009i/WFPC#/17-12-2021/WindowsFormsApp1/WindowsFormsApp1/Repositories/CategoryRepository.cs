using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WindowsFormsApp1.Models;

namespace WindowsFormsApp1.Repositories
{
    class CategoryRepository
    {
        public List<Category> GetCategories() {
            return new List<Category>()
            {
                new Category(){ 
                    CategoryId = 1,
                    CategoryName = "cat111"
                },
                new Category(){
                    CategoryId = 1,
                    CategoryName = "cat2222"
                }
                ,new Category(){
                    CategoryId = 1,
                    CategoryName = "cat333"
                }
            };
        }
    }
}
