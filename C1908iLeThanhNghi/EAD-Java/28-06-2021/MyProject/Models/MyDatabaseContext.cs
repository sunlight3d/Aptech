using System;
using Microsoft.EntityFrameworkCore;
namespace MyProject.Models
{
    public class MyDatabaseContext: DbContext
    {
        public DbSet<Student> Students { get; set; }
        public DbSet<Course> Courses { get; set; }

        //public MyDatabaseContext(DbContextOptions<MyDatabaseContext> options) : base(options)
        //{

        //}
    }
}
