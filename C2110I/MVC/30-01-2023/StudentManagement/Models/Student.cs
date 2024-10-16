using Microsoft.Build.Framework;
using StudentManagement.Validations;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;

namespace StudentManagement.Models
{
    public class Student
    {

        public int StudentID { get; set; }
        [DisplayName("Student's name")]
        public string StudentName { get; set; }        
        
        [EmailAddress(ErrorMessage ="Invalid email addresssssss")]
        public string Email { get; set;}

        [StringLength(200, MinimumLength =4, ErrorMessage ="Address must be 4 to 200 in length")]
        public string? Address { get; set; }
        [DataType(DataType.DateTime, ErrorMessage ="DOB must be Datetime")]
        [AgeGreaterThan(18, "Age must be >= 18")]
        public DateTime DOB { get; set; }

        //navigation property
        public ICollection<Enrollment> Enrollments { get; set; }
    }
}
