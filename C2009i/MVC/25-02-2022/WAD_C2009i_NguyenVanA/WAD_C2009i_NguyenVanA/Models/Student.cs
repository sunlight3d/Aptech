using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;
using WAD_C2009i_NguyenVanA.Validations;

namespace WAD_C2009i_NguyenVanA.Models
{
    public class Student
    {
        [Key]
        public int StudentId { get; set; }
        
        [Display(Name = "StudentName", ResourceType = typeof(Resources))]
        [Required(ErrorMessageResourceType = typeof(Resources),
            ErrorMessageResourceName = "StudentNameRequired")]
        [StringLength(150, MinimumLength =2, ErrorMessage ="Length must be between 2 and 150")]
        public string StudentName { get; set; }

        [Display(Name = "StudentDOB", ResourceType = typeof(Resources))]
        [Required(ErrorMessageResourceType = typeof(Resources),
            ErrorMessageResourceName = "StudentDOBRequired")]
        [DataType(DataType.DateTime, ErrorMessage ="This must be DateTime")]
        
        [MinimumAge(16, ErrorMessage ="Age must be >= 16")]
        public DateTime StudentDOB { get; set; }

        [Display(Name = "StudentClass", ResourceType = typeof(Resources))]
        [Required(ErrorMessageResourceType = typeof(Resources),
           ErrorMessageResourceName = "StudentClassRequired")]        
        public string StudentClass { get; set; }
        public virtual ICollection<Exam> Exams { get; set; }
        public Student() { 
            Exams = new List<Exam>();
        }
    }
}