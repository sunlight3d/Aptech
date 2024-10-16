using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;

namespace WAD_C1908i_DuongDucAnh.Models
{
    public class Exam
    {
        [Key]
        [Column(Order = 0)]
        public int StudentId { get; set; }
        [Key]
        [Column(Order = 1)]
        public int SubjectId { get; set; }
        public int Mark { get; set; }
    }
}