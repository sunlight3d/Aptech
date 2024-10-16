using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Configuration;
namespace _03_07_2023.Models
{
    
    public class MyDBContext : DbContext
    {
        public MyDBContext(DbContextOptions<MyDBContext> options): base(options)
        {
        }
        public DbSet<User> Users { get; set; }
        public DbSet<Department> Departments { get; set; }
        public DbSet<Employee> Employees { get; set; }
        public DbSet<Product> Products { get; set; }

        /*
        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            //optionsBuilder.UseSqlServer(Configuration.GetConnectionString("MyConnectionString"));
        }
        */
    }

}
