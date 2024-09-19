using ex001.Models;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using System.Collections;

namespace ex001.Controllers
{
    //[Route("api/[controller]")]
    [Route("api/products")]
    [ApiController]
    public class ProductController : ControllerBase
    {
        [HttpGet("")]
        public async  Task<IEnumerable<Product>> GetProducts() {
            return new List<Product>
            {
                new Product { 
                    Id = 1, 
                    Name = "Test",
                    Description = "Test",
                    Price  = 123
                }
            };
        }
    }
}
