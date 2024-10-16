using System;
using Microsoft.EntityFrameworkCore;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace myapp.Models
{
    [Table("etf_holdings")]
    public class EtfHolding
    {
        [Key, Column(Order = 0)]
        public int EtfId { get; set; }

        [Key, Column(Order = 1)]        
        public int StockId { get; set; }

        [Required]
        [Column("shares_held")]
        public decimal SharesHeld { get; set; }

        [Required]
        [Column("weight")]
        public decimal Weight { get; set; }

        [ForeignKey("EtfId")]
        public virtual ETF? Etf { get; set; }

        [ForeignKey("StockId")]
        public virtual Stock? Stock { get; set; }
    }
}

