using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace myapp.Models
{
    [Table("portfolios")]
    public class Portfolio
    {
        [Key]
        [Column("portfolio_id")]
        public int PortfolioId { get; set; }

        [Required]
        [Column("user_id")]
        public int UserId { get; set; }

        [Required]
        [Column("stock_id")]
        public int StockId { get; set; }

        [Required]
        [Range(1, int.MaxValue, ErrorMessage = "Quantity must be greater than 0")]
        [Column("quantity")]
        public int Quantity { get; set; }

        [Required]
        [Column("purchase_price")]
        public decimal PurchasePrice { get; set; }

        [Required]
        [Column("purchase_date")]
        public DateTime PurchaseDate { get; set; }

        [ForeignKey("UserId")]
        public virtual User? User { get; set; }

        [ForeignKey("StockId")]
        public virtual Stock? Stock { get; set; }
    }
}
