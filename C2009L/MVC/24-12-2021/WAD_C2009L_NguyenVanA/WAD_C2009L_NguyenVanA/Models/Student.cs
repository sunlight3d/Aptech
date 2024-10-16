using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations;

namespace WAD_C2009L_NguyenVanA.Models
{
    public class Student
    {
        [Key]
        public int StudentId { get; set; }
        [Required]
        [Display(Name = "StudentName", ResourceType = typeof(Resource))]

        [StringLength(150, MinimumLength = 2,
            ErrorMessage = "Length must be between 2 and 150")]
        public String StudentName { get; set; }
        
        [Required]
        [Display(Name = "StudentDOB", ResourceType = typeof(Resource))]
        [DataType(DataType.DateTime, ErrorMessage ="This must be DateTime")]
        [MinimumAge(16)]
        public DateTime StudentDOB { get; set; }
        [Required]
        public String StudentClass { get; set; }
        public virtual ICollection<Exam> Exams { get; set; }
        //constructor
        public Student()
        {
            this.Exams = new List<Exam>();
        }
    }
}