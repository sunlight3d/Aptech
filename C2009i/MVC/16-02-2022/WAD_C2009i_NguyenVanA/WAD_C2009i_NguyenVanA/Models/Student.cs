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
        public string StudentName { get; set; }
        public DateTime StudentDOB { get; set; }
        public string StudentClass { get; set; }
        public virtual ICollection<Exam> Exams { get; set; }
        public Student() { 
            Exams = new List<Exam>();
        }
    }
}