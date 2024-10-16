using System.ComponentModel.DataAnnotations;

namespace StudentManagement.Models
{
    public class Student
    {
        [Key]
        public int StudentID { get; set; }
        public string StudentName { get; set; }
        public string Email { get; set;}//not null
        public string? Address { get; set; } //nullable
        public DateTime DOB { get; set; }
        public ICollection<Enrollment> Enrollments { get; set; }

    }
}
