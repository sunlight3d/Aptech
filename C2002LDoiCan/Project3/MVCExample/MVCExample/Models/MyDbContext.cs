using System;
using Microsoft.EntityFrameworkCore;
namespace MVCExample.Models
{
    public class MyDbContext : DbContext
    {
        public DbSet<Product> Products { get; set; }
    }
}
