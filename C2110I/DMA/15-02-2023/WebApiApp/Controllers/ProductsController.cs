using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.Primitives;
using WebApiApp.Models;
using WebApiApp.Utilities;

namespace WebApiApp.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ProductsController : ControllerBase
    {
        private readonly MyDBContext _context;
        private readonly IConfiguration _configuration;
        public ProductsController(MyDBContext context, IConfiguration configuration) {
            //Dependency injection
            _context = context;
            _configuration = configuration;
            //generate fake data
            
            if (!_context.Products.Any()) {
                var products = new List<Product>
                    {
                        new Product {Name = "Product 1", Description = "Description 1", Price = 10.99m },
                        new Product {Name = "Product 2", Description = "Description 2", Price = 19.99m },
                        new Product {Name = "Product 3", Description = "Description 3", Price = 25.99m }
                    };
                _context.Products.AddRange(products); //ok, insert bundle                                                      
                context.SaveChanges();
            }                        
        }
        
        [HttpGet("GetAllProducts")]
        //http:localhost:12345/api/Products/GetAllProducts
        public ActionResult<IEnumerable<Product>> Get()
        {
            return Ok(_context.Products.Take(100).ToList());            
        }                      
        
    }
}
