using Microsoft.EntityFrameworkCore;
using System;
namespace bai05.Models
{
   
    public class DataContext : DbContext
    {
        public DataContext(DbContextOptions<DataContext> options) : base(options)
        {
        }

        public DbSet<Product> Products { get; set; }
        public DbSet<Order> Orders { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);

            // Set up primary keys
            modelBuilder.Entity<Product>().HasKey(p => p.Id);
            modelBuilder.Entity<Order>().HasKey(o => o.Id);

            // Set up foreign key relationship
            modelBuilder.Entity<Order>()
                .HasOne<Product>(o => o.Product) // Order has one Product
                .WithMany() // Product can be associated with many Orders
                .HasForeignKey(o => o.ProductId); // Foreign key

            // Additional configurations can be set here
        }
    }

}
