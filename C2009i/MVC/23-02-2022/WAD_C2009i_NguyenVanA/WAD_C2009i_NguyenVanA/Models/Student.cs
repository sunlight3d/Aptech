using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace WAD_C2009i_NguyenVanA.Models
{
    public class Student
    {
        [Key]
        public int StudentId { get; set; }
        
        [Display(Name = "StudentName", ResourceType = typeof(Resources))]
        [Required(ErrorMessageResourceType = typeof(Resources),
            ErrorMessageResourceName = "StudentNameRequired")]
        public string StudentName { get; set; }

        [Display(Name = "StudentDOB", ResourceType = typeof(Resources))]
        [Required(ErrorMessageResourceType = typeof(Resources),
            ErrorMessageResourceName = "StudentDOBRequired")]
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