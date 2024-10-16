using System;
using MVCExample.Models;
namespace MVCExample.Repositories
{
    public interface IProductRepository
    {
        public void InsertProduct(Product product);
    }
}
