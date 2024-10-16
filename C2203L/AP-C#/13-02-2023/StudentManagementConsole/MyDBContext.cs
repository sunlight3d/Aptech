using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StudentManagementConsole
{
    public class MyDBContext : DbContext
    {
        private const string connectionString = "Server=DESKTOP-MCC6BQT;Database=StudentManagement;Trusted_Connection=True;Encrypt=False;";
        public DbSet<Student> Students { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            optionsBuilder.UseSqlServer(connectionString);
        }
    }
}
