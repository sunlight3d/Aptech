using Microsoft.EntityFrameworkCore;

namespace JsonWSApp.Models
{
    public class DataContext: DbContext {
        private readonly IConfiguration configuration;
        public DataContext(DbContextOptions<DataContext> options): base(options)
        {
            Console.WriteLine("aa");
        }
        public DbSet<Product> Products { get; set; }

    }
}
