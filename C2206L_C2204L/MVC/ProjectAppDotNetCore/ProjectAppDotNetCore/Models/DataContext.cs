using JetBrains.Annotations;
using Microsoft.EntityFrameworkCore;

namespace ProjectAppDotNetCore.Models
{
    public class DataContext:DbContext
    {        

        public DataContext(DbContextOptions<DataContext> options) : base(options)
        {
            DataInitializer.Seed(this);
        }

        public virtual DbSet<Project> Projects { get; set; }
        public virtual DbSet<Employee> Employees { get; set; }
        public virtual DbSet<ProjectEmployee> ProjectEmployees { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            base.OnConfiguring(optionsBuilder);
        }

    }
}
