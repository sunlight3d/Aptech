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
        public int ExamId {get; set; }
        
        public int StudentId { get; set; }                
        public int SubjectId { get; set; }

        [Display(Name = "Mark", ResourceType = typeof(Resources))]        
        [Required(ErrorMessageResourceType = typeof(Resources), 
            ErrorMessageResourceName = "MarkRequired")]
        [Range(0, 100)]
        public int Mark { get; set; }
        //references
        public virtual Student Student { get; set; }
        public virtual Subject Subject { get; set;}
    }
}