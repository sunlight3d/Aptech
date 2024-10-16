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
        public string StudentName { get; set; }
        public DateTime StudentDOB { get; set; }
        public string StudentClass { get; set; }
        public virtual ICollection<Exam> Exams { get; set; }

        public Student() {
            this.Exams = new HashSet<Exam>();
        }
    }
}