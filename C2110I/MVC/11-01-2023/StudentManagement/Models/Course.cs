using StudentManagement.Validations;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace StudentManagement.Models
{
    public class Course
    {
        [DatabaseGenerated(DatabaseGeneratedOption.None)]
        public int CourseID { get; set; }
        [DisplayName("Course's name")]

        [Required]
        [UpperCaseCourseName]
        public string CourseName { get; set; }
        [DisplayName("Description")]
        public string? Description { get; set; }
        [DisplayName("Duration, eg: 12 hours")]
        [Range(1, 120)]
        public int Duration { get; set; }
        public DateTime StartDate { get; set; }
        
        //navigation property
        public ICollection<Enrollment> Enrollments { get; set; }
    }
}
