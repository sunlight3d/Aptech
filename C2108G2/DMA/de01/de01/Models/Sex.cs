using System;
using System.ComponentModel.DataAnnotations;

namespace de01.Models
{
    public class Sex
    {
        [Key]
        public int SexID { get; set; }

        [StringLength(255, ErrorMessage = "Sex name cannot be longer than 255 characters")]
        public string SexName { get; set; }

        public ICollection<Diploma> Diplomas { get; set; }
    }

}

