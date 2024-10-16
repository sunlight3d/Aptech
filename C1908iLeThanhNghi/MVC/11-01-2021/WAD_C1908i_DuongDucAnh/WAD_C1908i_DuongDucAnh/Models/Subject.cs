using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;
namespace WAD_C1908i_DuongDucAnh.Models
{
    public class Subject
    {
        [Key]
        public int SubjectId { get; set; }
        [Required]
        [StringLength(150, ErrorMessage ="Length must be in range 7 to 150", MinimumLength = 7)]
        public string SubjectName { get; set; }
        public virtual ICollection<Exam> Exams { get; set; }
        public Subject()
        {
            this.Exams = new HashSet<Exam>();
        }
    }
}