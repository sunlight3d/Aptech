using Microsoft.EntityFrameworkCore;

namespace myapp.Models
{
    public class MyDbContext : DbContext
    {
        public MyDbContext(DbContextOptions<MyDbContext> options)
            : base(options)
        {
        }

        public DbSet<Department> Departments { get; set; }
        public DbSet<Employee> Employees { get; set; }
        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Department>().HasData(
                new Department { 
                    Id = 1, Name = "Sales"
                },
                new Department
                {
                    Id = 2,
                    Name = "IT"
                }
            );
            modelBuilder.Entity<Employee>().HasData(
                new Employee
                {
                    Id = 1,
                    Name = "NGuyen van A",
                    Age = 18,
                    Sex = "Male",
                    DepartmentId = 1

                },
                new Employee
                {
                    Id = 2,
                    Name = "NGuyen van BB",
                    Age = 20,
                    Sex = "Female",
                    DepartmentId = 1
                }
            );
        }
    }
}
