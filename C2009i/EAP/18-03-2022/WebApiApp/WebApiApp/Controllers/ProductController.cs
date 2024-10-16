using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using WebApiApp.Models;

namespace WebApiApp.Controllers
{
    public class ProductController : ApiController
    {
        private List<Product> products = new List<Product>() {
                new Product {
                    Id = 1,
                    Name = "iphone 3",
                    Price = 882.3,
                    Description = "haha"
                },
                new Product {
                    Id = 2,
                    Name = "iphone 5",
                    Price = 88.3,
                    Description = "haha"
                },
                new Product
                {
                    Price = 9832.3,
                    Id = 3,
                    Name = "iphone 4",
                    Description = "haha"
                }
            };


        [HttpGet]
        public IEnumerable<Product> GetAllProducts()
        {
            return this.products;
        }
        [HttpGet]
        //api/product?id=3
        public Product GetProductById(int? id)
        {
            //Stream in Java
            return this.products
                .Where(product => id == null ? true: product.Id == id)
                .FirstOrDefault();
        }
    }
}
