﻿using Microsoft.EntityFrameworkCore.Metadata.Internal;
using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;

namespace perfumeapp.Models
{
    public class GiftCard
    {
        [Key]
        public int GiftCardID { get; set; }

        [ForeignKey("User")]
        public int UserID { get; set; }

        [Required]
        [Column(TypeName = "decimal(10,2)")]
        public decimal Amount { get; set; }

        public virtual User User { get; set; }
    }
}
