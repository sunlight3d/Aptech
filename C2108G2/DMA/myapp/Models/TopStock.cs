using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace myapp.Models
{
    public class TopStock
    {
        [Key]
        [ForeignKey("Stock")]
        [Column("stock_id")]
        public int StockId { get; set; }

        [Column("rank")]
        [Required(ErrorMessage = "Rank is required.")]
        public int Rank { get; set; }

        [Column("reason")]
        public string Reason { get; set; } = "";

        public Stock? Stock { get; set; }
    }
}

