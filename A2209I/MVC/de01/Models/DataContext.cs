using Microsoft.EntityFrameworkCore;

namespace de01.Models
{
    public class DataContext : DbContext
    {
        public DataContext(DbContextOptions<DataContext> options)
            : base(options)
        {
        }

        public DbSet<Customer> Customers { get; set; }
        public DbSet<Klass> Klasses { get; set; }
        
    }
}
