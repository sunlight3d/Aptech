using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;
using WAD_C1908i_DuongDucAnh.Models;
namespace WAD_C1908i_DuongDucAnh.Models
{
    public class Student
    {
        [Key]
        public int StudentId { get; set; }
        [Required]
        [StringLength(150, ErrorMessage = "Length must be in range 7 to 150", MinimumLength = 7)]
        public string StudentName { get; set; }
        [Required]
        [DataType(DataType.Date)]
        [DateMinimumAge(16, ErrorMessage = "Age must be >= 16")]
        public DateTime StudentDOB { get; set; }
        [Required]
        public string StudentClass { get; set; }
        public virtual ICollection<Exam> Exams { get; set; }

        public Student() {
            this.Exams = new HashSet<Exam>();
        }
    }
}