using Microsoft.EntityFrameworkCore;
namespace ECommerceApp.Models
{
    public class ECommerceDbContext : DbContext
    {
        public ECommerceDbContext(DbContextOptions<ECommerceDbContext> options)
            : base(options)
        {

        }

        public DbSet<User> Users { get; set; }
        public DbSet<Product> Products { get; set; }
        public DbSet<Category> Categories { get; set; }
        public DbSet<CartItem> CartItems { get; set; }
        public DbSet<Order> Orders { get; set; }
        public DbSet<OrderDetail> OrderDetails { get; set; }

        public void GenerateFakedProducts()
        {
            this.Database.EnsureCreated();
            var categories = new List<Category>
            {
                new Category { Name = "Electronics"},
                new Category { Name = "Electronics"},
                new Category { Name = "Clothing"},
                new Category { Name = "Home and Garden" },
                new Category { Name = "Toys and Games"}
            };
            if (!this.Categories.Any()) {
                Categories.AddRange(categories);
                this.SaveChanges();
            }
                
            var products = new List<Product>
                {
                    new Product
                    {
                        Name = "Product 1",
                        Description = "This is the description for Product 1.",
                        Price = 9.99m,
                        ImageUrl = "https://example.com/product1.jpg",
                        CategoryId = 1
                    },
                    new Product
                    {
                        Name = "Product 2",
                        Description = "This is the description for Product 2.",
                        Price = 14.99m,
                        ImageUrl = "https://example.com/product2.jpg",
                        CategoryId = 1
                    },
                    new Product
                    {
                        Name = "Product 3",
                        Description = "This is the description for Product 3.",
                        Price = 19.99m,
                        ImageUrl = "https://example.com/product3.jpg",
                        CategoryId = 2
                    }
                };
            if (!this.Products.Any())
            {
                this.Products.AddRange(products);
                this.SaveChanges();
            }

        }
    }
}
