using OwinApp.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Web.Http;

namespace OwinApp.Controllers
{
    public class ProductController : ApiController
    {
        // GET api/product        
        private IEnumerable<Product> products = new List<Product>() { 
            new Product { 
                Id = 1,                
                Year = 2021,
                Name = "iphone 12",
            }
        };
        public IEnumerable<Product> Get()
        {
            return products;
        }

        // GET api/values/5 
        public string Get(int id)
        {
            return "value";
        }

        // POST api/values 
        public void Post([FromBody] Product newProduct)
        {
            products.Append(newProduct);
        }

        // PUT api/values/5 
        public void Put(int id, [FromBody] string value)
        {
        }

        // DELETE api/values/5 
        public void Delete(int id)
        {
        }
    }
}
