using System;
using MVCExample.Models;
namespace MVCExample.Repositories
{
    public class ProductRepository : IProductRepository
    {
        public void InsertProduct(Product product)
        {
            Console.WriteLine("iinsert product ");
        }
    }
}
