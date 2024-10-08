using ex001.Models;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using System.Collections;

namespace ex001.Controllers
{
    [Route("api/[controller]s")]
    //[Route("api/products")]
    [ApiController]
    public class ProductController : ControllerBase
    {
        private static List<Product> products = new List<Product>
        {
            new Product { Id = 1, Name = "Laptop", Price = 999.99m },
            new Product { Id = 2, Name = "Smartphone", Price = 799.99m },
            new Product { Id = 3, Name = "Tablet", Price = 499.99m },
            new Product { Id = 4, Name = "Headphones", Price = 199.99m },
            new Product { Id = 5, Name = "Smartwatch", Price = 299.99m },
            new Product { Id = 6, Name = "Camera", Price = 899.99m },
            new Product { Id = 7, Name = "Printer", Price = 149.99m },
            new Product { Id = 8, Name = "Monitor", Price = 249.99m },
            new Product { Id = 9, Name = "Keyboard", Price = 49.99m },
            new Product { Id = 10, Name = "Mouse", Price = 29.99m }
        };

        [HttpGet("")]
        [AllowAnonymous]
        public async  Task<IEnumerable<Product>> GetProducts() {
            return ProductController.products;
        }

        [HttpPost("insert")]
        [Authorize(Policy = "AdminRequire")]
        public IActionResult InsertProduct([FromBody] Product product)
        {
            if (product == null)
            {
                return BadRequest("Product cannot be null."); //ma 404

            }

            // Optionally, assign an Id if not provided
            if (product.Id == 0)
            {
                product.Id = products.Max(p => p.Id) + 1;
            }

            products.Add(product);
            return Ok(products);
        }
        [HttpPut("{id}")]
        public IActionResult UpdateProduct(int id, [FromBody] Product product)
        {
            if (product == null)
            {
                return BadRequest("Thông tin sản phẩm không hợp lệ."); // mã 400
            }

            var existingProduct = products.FirstOrDefault(p => p.Id == id);
            if (existingProduct == null)
            {
                return NotFound("Không tìm thấy sản phẩm."); // mã 404
            }

            // Cập nhật thông tin sản phẩm
            existingProduct.Name = product.Name;
            existingProduct.Price = product.Price;
            existingProduct.Description = product.Description ?? existingProduct.Description;
            // Cập nhật các thuộc tính khác nếu cần

            return Ok(existingProduct); // mã 200
        }
        [HttpDelete("delete/{id}")]
        public IActionResult DeleteProduct(int id)
        {
            var product = products.FirstOrDefault(p => p.Id == id);
            if (product == null)
            {
                return NotFound("Không tìm thấy sản phẩm."); // mã 404
            }

            products.Remove(product);
            return Ok("Đã xóa sản phẩm thành công."); // mã 200
        }


    }
}
