using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Migrations;
using System.Collections.Generic;

namespace WebApiApp.Models
{
    public class MyDBContext : DbContext
    {
        public MyDBContext(DbContextOptions<MyDBContext> options)
            : base(options)
        {
        }

        public DbSet<Product> Products { get; set; }
        public DbSet<User> Users { get; set; }
        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<User>().ToTable("Users");
            //Add-Migration AddUserTable
            //Update-Database AddUserTable

            //Add-Migration AddUserNameToUserTable 
            //Update-Database AddUserNameToUserTable 
            modelBuilder.Entity<Product>().ToTable("Products");
        }
    }

}

