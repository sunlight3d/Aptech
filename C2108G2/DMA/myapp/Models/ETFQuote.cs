using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace myapp.Models
{
    [Table("etf_quotes")]
    public class ETFQuote
    {
        [Key]
        [Column("quote_id")]
        public int Id { get; set; }

        [Required]
        [ForeignKey("ETF")]
        [Column("etf_id")]
        public int ETFId { get; set; }
        public virtual ETF? ETF { get; set; }

        [Required]
        [Column("price")]
        public decimal Price { get; set; }

        [Required]
        [Column("change")]
        public decimal Change { get; set; }

        [Required]
        [Column("percent_change")]
        public decimal PercentChange { get; set; }

        [Required]
        [Column("total_volume")]
        public int TotalVolume { get; set; }

        [Required]
        [Column("time_stamp")]
        public DateTime TimeStamp { get; set; }
    }
}

