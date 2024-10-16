using Microsoft.AspNetCore.Authentication;
using System.ComponentModel.DataAnnotations;

namespace StudentManagement.Models
{
    public class Course
    {
        [Key]
        public int CourseID { get; set; }
        public string CourseName { get; set; }
        public DateOnly StartDate { get; set; }
        public int Duration { get; set; }        

        public ICollection<Enrollment> Enrollments { get; set; }
    }
}
