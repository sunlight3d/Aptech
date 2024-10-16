using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace WAD_C2009i_NguyenVanA.Models
{
    public class Exam
    {
        [Key]
        [Column(Order = 1)]
        public int StudentId { get; set; }
        [Key]
        [Column(Order = 2)]
        public int SubjectId { get; set; }

        [Display(Name = "Mark", ResourceType = typeof(Resources))]
        [Required(ErrorMessageResourceType = typeof(Resources), 
            ErrorMessageResourceName = "MarkRequired")]
        public int Mark { get; set; }
        //references
        public virtual Student Student { get; set; }
        public virtual Subject Subject { get; set;}
    }
}