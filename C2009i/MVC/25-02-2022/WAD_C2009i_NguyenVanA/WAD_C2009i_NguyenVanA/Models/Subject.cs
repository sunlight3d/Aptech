using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace WAD_C2009i_NguyenVanA.Models
{
    public class Subject
    {
        [Key]
        public int SubjectId { get; set; }
        [Required(ErrorMessage ="You must enter subject's name")]
        public String SubjectName { get; set; }
        public virtual ICollection<Exam> Exams { get; set; }
        public Subject()
        {
            this.Exams = new List<Exam>();
        }
    }
}