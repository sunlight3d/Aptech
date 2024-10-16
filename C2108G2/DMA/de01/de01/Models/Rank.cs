using System;
using System.ComponentModel.DataAnnotations;

namespace de01.Models
{
    public class Rank
    {
        [Key]
        public int RankID { get; set; }

        [StringLength(50, ErrorMessage = "Rank name cannot be longer than 50 characters")]
        public string RankName { get; set; }

        public float? FromPoint { get; set; }

        public float? ToPoint { get; set; }

        public ICollection<Diploma> Diplomas { get; set; }
    }
}

