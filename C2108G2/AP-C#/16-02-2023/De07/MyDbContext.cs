using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace De07
{
    public class MyDbContext : DbContext
    {
        public DbSet<Cat> Cats { get; set; }
        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            try
            {
                optionsBuilder.UseSqlServer(Constants.CONNECTION_STRING);
            }
            catch (Exception e) { 
                Console.WriteLine(e);
            }
        }
    }
}
