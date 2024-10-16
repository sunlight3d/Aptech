using Microsoft.EntityFrameworkCore;

namespace StudentManagement.Models
{
    public class StudentManagementContext: DbContext
    {
        public StudentManagementContext(DbContextOptions<StudentManagementContext> options)
       : base(options)
        {

        }

        public DbSet<Course> Courses { get; set; }
        public DbSet<Enrollment> Enrollments { get; set; }
        public DbSet<Student> Students { get; set; }
    }
}
